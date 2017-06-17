package ru.tchallenge.service.kernel.domain.account.realm;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class AccountRealmFacade extends EnumeratedEntityFacade<AccountRealm> {

    @Autowired
    private EnumeratedEntityMapper<AccountRealm> mapper;

    @Autowired
    private EnumeratedEntityRepository<AccountRealm> repository;

    @Override
    protected EnumeratedEntityMapper<AccountRealm> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<AccountRealm> getRepository() {
        return repository;
    }
}
