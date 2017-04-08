package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;

@RestController
@RequestMapping(path = "/data/accounts")
public class AccountControllerBean extends GenericController {

    @Autowired
    private AccountFacade facade;

    @RequestMapping(method = RequestMethod.PUT)
    public AccountInfo update(@RequestBody final AccountInvoice invoice) {
        return facade.update(normalize(invoice, new AccountInvoice()));
    }
}
