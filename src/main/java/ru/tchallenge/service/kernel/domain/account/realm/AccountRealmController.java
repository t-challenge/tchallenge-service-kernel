package ru.tchallenge.service.kernel.domain.account.realm;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/accounts/realms")
public class AccountRealmController extends EnumeratedEntityController<AccountRealm> {

    @Autowired
    private EnumeratedEntityFacade<AccountRealm> facade;

    @Override
    protected EnumeratedEntityFacade<AccountRealm> getFacade() {
        return facade;
    }
}
