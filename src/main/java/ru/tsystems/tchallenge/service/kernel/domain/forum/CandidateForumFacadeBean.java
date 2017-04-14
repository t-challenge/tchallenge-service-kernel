package ru.tsystems.tchallenge.service.kernel.domain.forum;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;

@FacadeService
public class CandidateForumFacadeBean extends GenericFacade implements CandidateForumFacade {

    @Override
    public CandidateForumInfo get(final String textcode) {
        throw new UnsupportedOperationException();
    }
}
