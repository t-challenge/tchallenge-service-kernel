package ru.tsystems.tchallenge.service.kernel.domain.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;

@RestController
@RequestMapping(path = "/data/candidates/samples")
public class CandidateSampleControllerBean extends GenericController {

    @Autowired
    private CandidateSampleFacade sampleFacade;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CandidateSampleInfo get(@PathVariable("id") final Long id) {
        return sampleFacade.get(id);
    }
}
