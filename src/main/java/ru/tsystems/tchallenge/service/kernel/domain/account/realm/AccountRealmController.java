package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/accounts/realms")
public class AccountRealmController extends EnumeratedEntityController<AccountRealm> {

    @Autowired
    private EnumeratedEntityFacade<AccountRealm> facade;

    @Override
    protected EnumeratedEntityFacade<AccountRealm> getFacade() {
        return facade;
    }
}
