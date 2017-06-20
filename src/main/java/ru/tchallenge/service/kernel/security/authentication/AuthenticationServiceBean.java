package ru.tchallenge.service.kernel.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.domain.account.Account;
import ru.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tchallenge.service.kernel.domain.account.AccountMapper;
import ru.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tchallenge.service.kernel.generic.GenericService;
import ru.tchallenge.service.kernel.security.rescue.RescueInfo;
import ru.tchallenge.service.kernel.security.rescue.RescueService;
import ru.tchallenge.service.kernel.security.token.TokenInfo;
import ru.tchallenge.service.kernel.security.token.TokenService;
import ru.tchallenge.service.kernel.utility.encryption.EncryptionService;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@ServiceComponent
public class AuthenticationServiceBean extends GenericService implements AuthenticationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private RescueService rescueService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    @Override
    public AuthenticationInfo createByLoginPasswordPair(final String login,
                                                        final String password) {
        final Account account = accountByLogin(login);
        ensureAccountLegality(account, password);
        final AccountInfo accountInfo = accountInfo(account);
        final TokenInfo tokenInfo = tokenService.createByLogin(account.getLogin());
        return authentication(accountInfo, tokenInfo);
    }

    @Override
    public AuthenticationInfo createByPermanentKeyId(final String permanentKeyId) {
        final Account account = accountByPermanentKeyId(permanentKeyId);
        final AccountInfo accountInfo = accountInfo(account);
        return authentication(accountInfo);
    }

    @Override
    public AuthenticationInfo createByRescueId(final String rescueId) {
        final RescueInfo rescueInfo = rescueService.getAndRemove(rescueId);
        final Account account = accountByEmail(rescueInfo.getEmail());
        final AccountInfo accountInfo = accountInfo(account);
        final TokenInfo tokenInfo = tokenService.createByLogin(account.getLogin());
        return authentication(accountInfo, tokenInfo);
    }

    @Override
    public AuthenticationInfo createByTokenId(final String tokenId) {
        final TokenInfo tokenInfo = tokenById(tokenId);
        final Account account = accountByLogin(tokenInfo.getLogin());
        final AccountInfo accountInfo = accountInfo(account);
        return authentication(accountInfo, tokenInfo);
    }

    private AuthenticationInfo authentication(final AccountInfo account) {
        return new AuthenticationInfo(account, null);
    }

    private AuthenticationInfo authentication(final AccountInfo account, final TokenInfo token) {
        return new AuthenticationInfo(account, token);
    }

    private Account accountByEmail(final String email) {
        final Account account = accountRepository.findByLogin(email);
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return account;
    }

    private Account accountByLogin(final String login) {
        final Account account = accountRepository.findByLogin(login);
        ensureAccountAvailability(account);
        ensureAccountStatus(account);
        return account;
    }

    private Account accountByPermanentKeyId(final String permanentKeyId) {
        // TODO: implement this method
        throw new UnsupportedOperationException();
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

    private AccountInfo accountInfo(final Account account) {
        return accountMapper.info(account);
    }

    private TokenInfo tokenById(final String id) {
        return tokenService.getById(id);
    }
}
