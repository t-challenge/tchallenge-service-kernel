package ru.tsystems.tchallenge.service.kernel.domain.account;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class AccountMapperBean extends GenericMapper implements AccountMapper {

    public AccountInfo accountInfo(final Account account) {
        return new AccountInfo(
                account.getEmail(),
                account.getLogin(),
                account.getRealm().getId(),
                account.getStatus().getId(),
                account.getCreatedAt(),
                account.getModifiedAt()
        );
    }
}
