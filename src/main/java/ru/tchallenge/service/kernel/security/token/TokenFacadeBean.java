package ru.tchallenge.service.kernel.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationService;
import ru.tchallenge.service.kernel.security.credential.EmailCredentialInvoice;
import ru.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;
import ru.tchallenge.service.kernel.security.credential.SimpleLogonPairValidator;
import ru.tchallenge.service.kernel.utility.mail.MailInvoice;
import ru.tchallenge.service.kernel.utility.mail.MailService;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@Service
@Transactional(readOnly = true)
public class TokenFacadeBean extends GenericFacade implements TokenFacade {

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SimpleLogonPairValidator simpleLogonPairValidator;

    @Autowired
    private MailService mailService;

    @Override
    public TokenInfo create(final SimpleLogonPairInvoice credential) {
        ensureCredential(credential);
        return authenticate(credential).getToken();
    }

    @Override
    public void createAndMail(final EmailCredentialInvoice credential) {

        final TokenInfo info = authenticationService.create(credential).getToken();
        final MailInvoice mailInvoice = new MailInvoice();
        mailInvoice.setTarget(credential.getEmail());
        mailInvoice.setSubject("Ваш аккаунт в T-Challenge");
        final String delimiter = credential.getFlashback().contains("?") ? "&" : "?";
        final String url = credential.getFlashback() + delimiter + "token=" + info.getId();
        mailInvoice.setContent("<html><head><meta charset=\"UTF-8\"></head><body><h3>Вход в Ваш аккаунт:</h3>" +
                "<a href=\"" + url + "\">Воспользуйтесь этой ссылкой для перехода в T-Challenge</a></body></html>");
        mailService.send(mailInvoice);
    }

    @Override
    public void removeAll() {
        tokenService.removeByLogin(token().getLogin());
    }

    @Override
    public void removeCurrent() {
        tokenService.removeById(token().getId());
    }

    private AuthenticationInfo authenticate(final SimpleLogonPairInvoice pair) {
        return authenticationService.create(pair);
    }

    private SimpleLogonPairInvoice ensureCredential(final SimpleLogonPairInvoice credential) {
        return simpleLogonPairValidator.ensure(credential);
    }

    private TokenInfo token() {
        final AuthenticationInfo authentication = this.getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        return authentication.getToken();
    }
}
