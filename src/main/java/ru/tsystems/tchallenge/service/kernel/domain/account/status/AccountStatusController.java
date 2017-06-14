package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/accounts/statuses")
public class AccountStatusController extends EnumeratedEntityController<AccountStatus> {

    @Autowired
    private EnumeratedEntityFacade<AccountStatus> facade;

    @Override
    protected EnumeratedEntityFacade<AccountStatus> getFacade() {
        return facade;
    }
}
