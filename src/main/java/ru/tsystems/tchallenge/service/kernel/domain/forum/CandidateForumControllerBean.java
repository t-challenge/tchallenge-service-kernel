package ru.tsystems.tchallenge.service.kernel.domain.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;

@RestController
@RequestMapping(path = "/data/candidates/forums")
public class CandidateForumControllerBean extends GenericController {

    private final CandidateForumFacade forumFacade;

    @Autowired
    public CandidateForumControllerBean(final CandidateForumFacade forumFacade) {
        this.forumFacade = forumFacade;
    }

    @RequestMapping(path = "/{textcode}", method = RequestMethod.GET)
    public CandidateForumInfo get(@PathVariable("textcode") final String textcode) {
        return forumFacade.get(textcode);
    }
}
