package ru.tsystems.tchallenge.service.kernel.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateInfo;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeInfo;
import ru.tsystems.tchallenge.service.kernel.domain.system.SystemInfo;
import ru.tsystems.tchallenge.service.kernel.security.SecurityContext;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

public abstract class GenericFacade extends GenericService {

    @Autowired
    private SecurityContext securityContext;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    protected SecurityContext getSecurityContext() {
        return securityContext;
    }

    protected AuthenticationInfo authenticated() {
        final AuthenticationInfo authentication = securityContext.getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthenticated();
        }
        return authentication;
    }

    protected AccountInfo authenticatedAccount() {
        return authenticated().getAccount();
    }

    protected String authenticatedAccountLogin() {
        return authenticated().getAccount().getLogin();
    }

    protected CandidateInfo authenticatedCandidate() {
        return authenticatedSpecified(AuthenticationInfo::getCandidate);
    }

    protected EmployeeInfo authenticatedEmployee() {
        return authenticatedSpecified(AuthenticationInfo::getEmployee);
    }

    protected EmployeeInfo authenticatedEmployeeWithAll(final String... roles) {
        final EmployeeInfo employee = authenticatedEmployee();
        hasAllRoles(roles, employee.getRoles());
        return employee;
    }

    protected EmployeeInfo authenticatedEmployeeWithAny(final String... roles) {
        final EmployeeInfo employee = authenticatedEmployee();
        hasAnyRole(roles, employee.getRoles());
        return employee;
    }

    protected SystemInfo authenticatedSystem() {
        return authenticatedSpecified(AuthenticationInfo::getSystem);
    }

    protected SystemInfo authenticatedSystemWithAll(final String... roles) {
        final SystemInfo system = authenticatedSystem();
        hasAllRoles(roles, system.getRoles());
        return system;
    }

    protected SystemInfo authenticatedSystemWithAny(final String... roles) {
        final SystemInfo system = authenticatedSystem();
        hasAnyRole(roles, system.getRoles());
        return system;
    }

    private <T> T authenticatedSpecified(final Function<AuthenticationInfo, T> specifier) {
        final AuthenticationInfo authentication = authenticated();
        final T specifiedInfo = specifier.apply(authentication);
        if (specifiedInfo == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        return specifiedInfo;
    }

    private void hasAnyRole(final String[] sample, final Collection<String> roles) {
        for (String role : sample) {
            if (roles.contains(role)) {
                return;
            }
        }
        accessValidationExceptionEmitter.unauthorized();
    }

    private void hasAllRoles(final String[] sample, final Collection<String> roles) {
        if (roles.containsAll(Arrays.asList(sample))) {
            accessValidationExceptionEmitter.unauthorized();
        }
    }
}
