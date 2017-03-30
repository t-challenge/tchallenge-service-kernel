package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<CandidateInfo> getAll() {
        return candidateService.getAll();
    }

    @RequestMapping(path = "/{login}", method = RequestMethod.GET)
    public CandidateInfo getByLogin(@PathVariable("login") String login) {
        return candidateService.getByLogin(login);
    }
}
