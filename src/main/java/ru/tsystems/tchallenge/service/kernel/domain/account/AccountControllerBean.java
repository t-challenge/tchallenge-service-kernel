package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

@RestController
@RequestMapping(path = "/data/accounts")
public class AccountControllerBean {

    @Autowired
    private AccountFacade accountFacade;

    @RequestMapping(method = RequestMethod.POST)
    public AccountInfo create(@RequestBody final AccountInvoice invoice) {
        return accountFacade.create(invoice);
    }

    @RequestMapping(path = "/{login}", method = RequestMethod.GET)
    public AccountInfo get(@PathVariable("login") final String login) {
        return accountFacade.get(login);
    }

    @RequestMapping(path = "/authenticated", method = RequestMethod.GET)
    public AccountInfo getAuthenticated() {
        return accountFacade.getAuthenticated();
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchInfo<AccountInfo> search(final AccountSearchInvoice invoice) {
        return accountFacade.search(invoice);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AccountInfo update(@RequestBody final AccountInvoice invoice) {
        return accountFacade.update(invoice);
    }

    @RequestMapping(path = "/validation", method = RequestMethod.POST)
    public Object validate(@RequestBody final AccountInvoice invoice) {
        return accountFacade.validate(invoice);
    }
}
