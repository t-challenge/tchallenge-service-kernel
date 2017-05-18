package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

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
