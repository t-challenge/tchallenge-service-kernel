package ru.tchallenge.service.kernel.domain.candidate;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class CandidateMapper extends GenericMapper {

    public CandidateInfo info(final Candidate candidate) {
        final CandidateInfo info = new CandidateInfo();
        info.setGithub(candidate.getGithub());
        info.setCv(candidate.getCv());
        info.setSelfie(candidate.getSelfie());
        info.setInterested(flag(candidate.getInterested()));
        return info;
    }
}
