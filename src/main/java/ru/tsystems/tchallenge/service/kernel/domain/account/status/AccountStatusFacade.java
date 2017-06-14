package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class AccountStatusFacade extends EnumeratedEntityFacade<AccountStatus> {

    @Autowired
    private EnumeratedEntityMapper<AccountStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<AccountStatus> repository;

    @Override
    protected EnumeratedEntityMapper<AccountStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<AccountStatus> getRepository() {
        return repository;
    }
}
