package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateMapper;
import ru.tsystems.tchallenge.service.kernel.domain.employee.Employee;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeMapper;
import ru.tsystems.tchallenge.service.kernel.domain.person.Person;
import ru.tsystems.tchallenge.service.kernel.domain.person.PersonMapper;
import ru.tsystems.tchallenge.service.kernel.domain.robot.Robot;
import ru.tsystems.tchallenge.service.kernel.domain.robot.RobotMapper;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class AccountMapper extends GenericMapper {

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private RobotMapper robotMapper;

    public AccountInfo info(final Account account) {
        final AccountInfo info = new AccountInfo();
        info.setEmail(account.getEmail());
        info.setLogin(account.getLogin());
        info.setRealm(account.getRealm().getId());
        info.setStatus(account.getStatus().getId());
        final Candidate candidate = account.getCandidate();
        if (candidate != null) {
            info.setCandidate(candidateMapper.info(candidate));
        }
        final Employee employee = account.getEmployee();
        if (employee != null) {
            info.setEmployee(employeeMapper.info(employee));
        }
        final Person person = account.getPerson();
        if (person != null) {
            info.setPerson(personMapper.info(person));
        }
        final Robot robot = account.getRobot();
        if (robot != null) {
            info.setRobot(robotMapper.info(robot));
        }
        return info;
    }
}
