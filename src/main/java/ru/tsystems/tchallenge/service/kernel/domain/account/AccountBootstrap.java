package ru.tsystems.tchallenge.service.kernel.domain.account;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRoleBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRoleRepository;
import ru.tsystems.tchallenge.service.kernel.domain.person.Person;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmRepository;
import ru.tsystems.tchallenge.service.kernel.domain.robot.role.RobotRoleBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.robot.role.RobotRoleRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class AccountBootstrap extends OrdinalEntityBootstrap<Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRealmBootstrap realmBootstrap;

    @Autowired
    private AccountRealmRepository realmRepository;

    @Autowired
    private AccountStatusBootstrap statusBootstrap;

    @Autowired
    private AccountStatusRepository statusRepository;

    @Autowired
    private EmployeeRoleBootstrap employeeRoleBootstrap;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private RobotRoleBootstrap robotRoleBootstrap;

    @Autowired
    private RobotRoleRepository robotRoleRepository;

    @Override
    protected void collectEntities(Collection<Account> accounts) {
        accounts.add(sidorov());
    }

    private Account sidorov() {
        final Account account = new Account();
        account.setEmail("ivan.sidorov@some-email.com");
        account.setLogin("ivan.sidorov@some-email.com");
        account.setSecretHash("hash");
        account.setRealm(realmRepository.findById("CANDIDATE"));
        account.setStatus(statusRepository.findById("APPROVED"));
        account.setCandidate(candidate("ivan.sidorov"));
        account.setPerson(person("Иван", "Сидоров"));
        return account;
    }

    private Candidate candidate(final String github) {
        final Candidate candidate = new Candidate();
        candidate.setGithub(github);
        return candidate;
    }

    private Person person(final String firstname, final String lastname) {
        final Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setQuickname(firstname);
        return person;
    }

    @Override
    protected GenericEntityRepository<Account, Long> getRepository() {
        return accountRepository;
    }
}
