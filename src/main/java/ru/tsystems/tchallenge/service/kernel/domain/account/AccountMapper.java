package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountMapper extends GenericMapper {

    public AccountInfo accountInfo(Account account) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setEmail(account.getEmail());
        accountInfo.setLogin(account.getLogin());
        accountInfo.setRealm(enumeratedId(account.getRealm()));
        accountInfo.setStatus(enumeratedId(account.getStatus()));
        accountInfo.setCreatedAt(timestamp(account.getCreatedAt()));
        accountInfo.setModifiedAt(timestamp(account.getModifiedAt()));
        return accountInfo;
    }
}
