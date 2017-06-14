package ru.tsystems.tchallenge.service.kernel.generic;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

public abstract class EnumeratedEntityFacade<T extends EnumeratedEntity> extends GenericFacade {

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    public Collection<EnumeratedInfo> getAll() {
        authenticated();
        return getRepository()
                .findAll()
                .stream()
                .map(getMapper()::asInfo)
                .sorted()
                .collect(Collectors.toList());
    }

    protected abstract EnumeratedEntityMapper<T> getMapper();

    protected abstract EnumeratedEntityRepository<T> getRepository();

    private AccountInfo authenticated() {
        final AuthenticationInfo authentication = getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final AccountInfo account = authentication.getAccount();
        if (account == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        return account;
    }
}
