package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/systems")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<SystemInfo> getAll() {
        return systemService.getAll();
    }

    @RequestMapping(path = "/{login}", method = RequestMethod.GET)
    public SystemInfo getByLogin(@PathVariable("login") String login) {
        return systemService.getByLogin(login);
    }
}
