package ru.tsystems.tchallenge.service.kernel.domain.sample;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class CandidateSampleMapperBean extends GenericMapper implements CandidateSampleMapper {

    @Override
    public CandidateSampleInfo info(final Sample sample) {
        final CandidateSampleInfo info = new CandidateSampleInfo();
        info.setId(sample.getId());
        info.setTitle(sample.getTitle());
        info.setStatus(sample.getStatus().getId());
        return info;
    }
}
