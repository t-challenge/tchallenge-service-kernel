package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@Service
public class AccountMapper extends GenericMapper {

    public AccountInfo accountInfo(Account account) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setEmail(account.getEmail());
        accountInfo.setLogin(account.getLogin());
        accountInfo.setRealm(account.getRealm().getId());
        accountInfo.setStatus(account.getStatus().getId());
        accountInfo.setCreatedAt(account.getCreatedAt());
        accountInfo.setModifiedAt(account.getModifiedAt());
        return accountInfo;
    }
}
