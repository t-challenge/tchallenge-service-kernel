package ru.tsystems.tchallenge.service.kernel.domain.sample;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;

@FacadeService
public class CandidateSampleFacadeBean extends GenericFacade implements CandidateSampleFacade {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private CandidateSampleMapper sampleMapper;

    @Override
    public CandidateSampleInfo get(final Long id) {
        final Sample sample = sampleRepository.findById(id);
        return sampleMapper.info(sample);
    }
}
