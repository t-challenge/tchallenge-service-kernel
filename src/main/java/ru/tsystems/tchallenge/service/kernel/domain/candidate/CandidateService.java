package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountProperties;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericService;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CandidateService extends GenericService implements BootstrapAwareService<CandidateProperties> {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private AccountService accountService;

    @Override
    public CandidateInfo bootstrap(CandidateProperties candidateProperties) {
        bootstrapAccount(candidateProperties);
        return save(fromProperties(candidateProperties));
    }

    public CandidateInfo create(CandidateProperties candidateProperties) {
        createAccount(candidateProperties);
        return save(fromProperties(candidateProperties));
    }

    public Collection<CandidateInfo> getAll() {
        return candidateRepository
                .findAll()
                .stream()
                .map(this::info)
                .collect(Collectors.toList());
    }

    public CandidateInfo getByLogin(String login) {
        return info(byLogin(login));
    }

    private AccountInfo bootstrapAccount(CandidateProperties candidateProperties) {
        return accountService.bootstrap(accountProperties(candidateProperties));
    }

    private AccountInfo createAccount(CandidateProperties candidateProperties) {
        return accountService.create(accountProperties(candidateProperties));
    }

    private Candidate byLogin(String login) {
        return candidateRepository.findByLogin(login);
    }

    private CandidateInfo save(Candidate candidate) {
        return info(candidateRepository.save(candidate));
    }

    private CandidateInfo info(Candidate candidate) {
        return candidateMapper.candidateInfo(candidate);
    }

    private Candidate fromProperties(CandidateProperties candidateProperties) {
        Account account = accountByLogin(candidateProperties.getLogin());
        Candidate candidate = new Candidate(account.getId());
        candidate.setAccount(account);
        candidate.setFirstname(candidateProperties.getFirstname());
        candidate.setLastname(candidateProperties.getLastname());
        return candidate;
    }

    private Account accountByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    private AccountProperties accountProperties(CandidateProperties candidateProperties) {
        AccountProperties accountProperties = new AccountProperties();
        accountProperties.setEmail(candidateProperties.getEmail());
        accountProperties.setLogin(candidateProperties.getEmail());
        accountProperties.setSecret(candidateProperties.getSecret());
        accountProperties.setRealm(candidateRealm());
        return accountProperties;
    }

    private String candidateRealm() {
        return "CANDIDATE";
    }
}
