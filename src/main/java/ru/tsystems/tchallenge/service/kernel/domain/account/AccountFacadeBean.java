package ru.tsystems.tchallenge.service.kernel.domain.account;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;

@FacadeService
public class AccountFacadeBean extends GenericFacade implements AccountFacade {

    @Override
    public AccountInfo update(AccountInvoice invoice) {
        return null;
    }
}
