package ru.tsystems.tchallenge.service.kernel.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;
import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;

@RestController
@RequestMapping(path = "/security/tokens")
public class TokenControllerBean extends GenericController {

    @Autowired
    private TokenFacade tokenFacade;

    @RequestMapping(method = RequestMethod.POST)
    public TokenInfo create(@RequestBody final SimpleLogonPairInvoice credential) {
        return tokenFacade.create(credential);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeAll() {
        tokenFacade.removeAll();
    }

    @RequestMapping(path = "/current", method = RequestMethod.DELETE)
    public void removeCurrent() {
        tokenFacade.removeCurrent();
    }
}
