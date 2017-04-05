package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.GenericEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@Component
public class CandidateBootstrap extends GenericEntityBootstrap<Candidate, Long> {

    @Autowired
    private CandidateRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountBootstrap accountBootstrap;

    @Override
    protected void collectEntities(Collection<Candidate> entities) {
        entities.add(sidorov());
    }

    @Override
    protected GenericEntityRepository<Candidate, Long> getRepository() {
        return repository;
    }

    private Candidate sidorov() {
        return candidate("egor.sidorov@some-email.com", "Егор", "Сидоров");
    }

    private Candidate candidate(final String email,
                                final String firstname,
                                final String lastname) {
        final Account account = accountRepository.findByEmail(email);
        Candidate candidate = new Candidate(account.getId());
        candidate.setAccount(account);
        candidate.setFirstname(firstname);
        candidate.setLastname(lastname);
        return candidate;
    }
}
