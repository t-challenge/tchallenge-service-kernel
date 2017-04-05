package ru.tsystems.tchallenge.service.kernel.security.authentication;

import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateInfo;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeInfo;
import ru.tsystems.tchallenge.service.kernel.domain.system.SystemInfo;
import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenInfo;

public final class AuthenticationInfo extends GenericInfo {

    private final AccountInfo account;
    private final CandidateInfo candidate;
    private final EmployeeInfo employee;
    private final SystemInfo system;
    private final TokenInfo token;

    public AuthenticationInfo(final AccountInfo account,
                              final CandidateInfo candidate,
                              final EmployeeInfo employee,
                              final SystemInfo system,
                              final TokenInfo token) {
        this.account = account;
        this.candidate = candidate;
        this.employee = employee;
        this.system = system;
        this.token = token;
    }

    public AccountInfo getAccount() {
        return account;
    }

    public CandidateInfo getCandidate() {
        return candidate;
    }

    public EmployeeInfo getEmployee() {
        return employee;
    }

    public SystemInfo getSystem() {
        return system;
    }

    public TokenInfo getToken() {
        return token;
    }
}
