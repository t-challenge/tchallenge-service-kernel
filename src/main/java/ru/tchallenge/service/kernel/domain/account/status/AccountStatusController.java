package ru.tchallenge.service.kernel.domain.account.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/accounts/statuses")
public class AccountStatusController extends EnumeratedEntityController<AccountStatus> {

    @Autowired
    private EnumeratedEntityFacade<AccountStatus> facade;

    @Override
    protected EnumeratedEntityFacade<AccountStatus> getFacade() {
        return facade;
    }
}
