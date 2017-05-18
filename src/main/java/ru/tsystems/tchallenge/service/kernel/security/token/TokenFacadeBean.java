package ru.tsystems.tchallenge.service.kernel.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationService;
import ru.tsystems.tchallenge.service.kernel.security.credential.EmailCredentialInvoice;
import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;
import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairValidator;
import ru.tsystems.tchallenge.service.kernel.utility.mail.MailInvoice;
import ru.tsystems.tchallenge.service.kernel.utility.mail.MailService;

@Service
@Transactional(readOnly = true)
public class TokenFacadeBean extends GenericFacade implements TokenFacade {

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
        mailInvoice.setSubject("Вход в ваш аккаунт T-Challenge");
        final String delimiter = credential.getFlashback().contains("?") ? "&" : "?";
        final String url = credential.getFlashback() + delimiter + "token=" + info.getId();
        final String flashback = credential.getFlashback() != null ? credential.getFlashback() : "no";
        mailInvoice.setContent(String.format("Вход в Ваш аккаунт выполнен - воспользуйтесь это ссылкой для перехода в приложение: %s. Если Вы не выполняли этих действий, пожалуйста, обратитесь в службу поддержки.", url));
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
        return null;
    }
}
