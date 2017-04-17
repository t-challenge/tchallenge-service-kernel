package ru.tsystems.tchallenge.service.kernel.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountMapper;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenInfo;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenInvoice;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenService;
import ru.tsystems.tchallenge.service.kernel.utility.encryption.EncryptionService;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@Service
public class AuthenticationServiceBean implements AuthenticationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    @Override
    public AuthenticationInfo create(final SimpleLogonPairInvoice credential) {
        final Account account = accountByLogin(credential.getLogin());
        ensureAccountAvailability(account);
        ensureAccountLegality(account, credential.getSecret());
        ensureAccountStatus(account);
        return createAuthentication(account, createToken(credential.getLogin()));
    }

    @Override
    public AuthenticationInfo create(final String tokenId) {
        final TokenInfo token = tokenById(tokenId);
        final Account account = accountByLogin(token.getLogin());
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return createAuthentication(account, token);
    }

    private TokenInfo createToken(final String login) {
        final TokenInvoice tokenProperties = new TokenInvoice();
        tokenProperties.setLogin(login);
        return tokenService.create(tokenProperties);
    }

    private Account accountByLogin(final String login) {
        return accountRepository.findByLogin(login);
    }

    private TokenInfo tokenById(final String id) {
        return tokenService.getById(id);
    }

    private AuthenticationInfo createAuthentication(final Account account,
                                                    final TokenInfo token) {
        final String login = account.getLogin();
        final String realm = account.getRealm().getId();
        final AccountInfo accountInfo = accountMapper.info(account);
        return new AuthenticationInfo(accountInfo, token);
    }

    private void ensureAccountAvailability(final Account account) {
        if (account == null) {
            accessValidationExceptionEmitter.illegalCredential();
        }
    }

    private void ensureAccountLegality(final Account account, final String secret) {
        final String secretHash = encryptionService.accountSecretHash(secret);
        if (!account.getSecretHash().equals(secretHash)) {
            accessValidationExceptionEmitter.illegalCredential();
        }
    }

    private void ensureAccountStatus(final Account account) {
        final String status = account.getStatus().getId();
        if (status.equals("CREATED")) {
            accessValidationExceptionEmitter.accountNotApproved(status);
        }
        if (status.equals("SUSPENDED")) {
            accessValidationExceptionEmitter.accountSuspended(status);
        }
        if (status.equals("BLOCKED")) {
            accessValidationExceptionEmitter.accountBlocked(status);
        }
    }
}
