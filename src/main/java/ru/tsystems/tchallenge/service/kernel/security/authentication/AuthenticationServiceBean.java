package ru.tsystems.tchallenge.service.kernel.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountMapper;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.security.credential.EmailCredentialInvoice;
import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenInfo;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenInvoice;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenService;
import ru.tsystems.tchallenge.service.kernel.utility.encryption.EncryptionService;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@CommonService
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
    public AuthenticationInfo create(EmailCredentialInvoice credential) {
        final Account account = accountByEmail(credential.getEmail());
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return createAuthentication(account, createToken(account.getLogin()));
    }

    @Override
    public AuthenticationInfo create(final String tokenId) {
        if (tokenId.equals("CANDIDATE-HARDCODED-TOKEN")) {
            return createHardcodedCandidateToken();
        }
        if (tokenId.equals("EMPLOYEE-HARDCODED-TOKEN")) {
            return createHardcodedEmployeeToken();
        }
        if (tokenId.equals("EVENT-DASHBOARD-HARDCODED-TOKEN")) {
            return createHardcodedDashboardToken();
        }
        final TokenInfo token = tokenById(tokenId);
        if (token == null) {
            return null;
        }
        final Account account = accountByLogin(token.getLogin());
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return createAuthentication(account, token);
    }

    private AuthenticationInfo createHardcodedCandidateToken() {
        final Account account = accountByLogin("p.smirnov");
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return createAuthentication(account, createToken(account.getLogin()));
    }

    private AuthenticationInfo createHardcodedEmployeeToken() {
        final Account account = accountByLogin("ivan.sidorov@some-email.com");
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return createAuthentication(account, createToken(account.getLogin()));
    }

    private AuthenticationInfo createHardcodedDashboardToken() {
        final Account account = accountByLogin("event.dashboard");
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return createAuthentication(account, createToken(account.getLogin()));
    }

    private TokenInfo createToken(final String login) {
        final TokenInvoice tokenProperties = new TokenInvoice();
        tokenProperties.setLogin(login);
        return tokenService.create(tokenProperties);
    }

    private Account accountByEmail(final String email) {
        return accountRepository.findByEmail(email);
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
