package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericBootstrap;

@Component
public class CandidateBootstrap extends GenericBootstrap<CandidateProperties> {

    @Autowired
    private AccountRealmBootstrap accountRealmBootstrap;

    @Autowired
    private AccountStatusBootstrap accountStatusBootstrap;

    @Autowired
    private CandidateService candidateService;

    @Override
    protected BootstrapAwareService<CandidateProperties> getService() {
        return candidateService;
    }

    @Override
    protected void collectProperties(Collection<CandidateProperties> candidates) {
        candidates.add(sidorov());
    }

    private CandidateProperties sidorov() {
        return candidate("egor.sidorov@some-email.com", "Егор", "Сидоров");
    }

    private CandidateProperties candidate(String email, String firstname, String lastname) {
        CandidateProperties candidateProperties = new CandidateProperties();
        candidateProperties.setEmail(email);
        candidateProperties.setLogin(email);
        candidateProperties.setSecret(email);
        candidateProperties.setFirstname(firstname);
        candidateProperties.setLastname(lastname);
        return candidateProperties;
    }
}
