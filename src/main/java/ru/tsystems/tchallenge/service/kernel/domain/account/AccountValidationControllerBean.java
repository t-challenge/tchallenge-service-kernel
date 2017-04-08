package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;
import ru.tsystems.tchallenge.service.kernel.validation.ValidationInfo;

@RestController
@RequestMapping(path = "/data/accounts/validation")
public class AccountValidationControllerBean extends GenericController {

    private AccountValidationFacade facade;

    public ValidationInfo validateEmail(@RequestBody final AccountInvoice invoice) {
        return facade.validateEmail(normalize(invoice, new AccountInvoice()));
    }

    public ValidationInfo validateLogin(@RequestBody final AccountInvoice invoice) {
        return facade.validateLogin(normalize(invoice, new AccountInvoice()));
    }

    public ValidationInfo validateSecret(@RequestBody final AccountInvoice invoice) {
        return facade.validateSecret(normalize(invoice, new AccountInvoice()));
    }

    public ValidationInfo validateStatus(@RequestBody final AccountInvoice invoice) {
        return facade.validateStatus(normalize(invoice, new AccountInvoice()));
    }
}
