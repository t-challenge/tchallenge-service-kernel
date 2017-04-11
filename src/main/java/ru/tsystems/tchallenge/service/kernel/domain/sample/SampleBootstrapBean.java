package ru.tsystems.tchallenge.service.kernel.domain.sample;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.sample.status.SampleStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.sample.status.SampleStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class SampleBootstrapBean extends OrdinalEntityBootstrap<Sample> {

    @Autowired
    private SampleStatusBootstrap sampleStatusBootstrap;

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SampleStatusRepository sampleStatusRepository;

    @Override
    protected void collectEntities(final Collection<Sample> samples) {
        samples.add(sample("Sample 1", "sample 1 text", "CREATED"));
        samples.add(sample("Sample 2", "sample 2 text", "APPROVED"));
        samples.add(sample("Sample 3", "sample 3 text", "BLOCKED"));
    }

    @Override
    protected GenericEntityRepository<Sample, Long> getRepository() {
        return sampleRepository;
    }

    private Sample sample(final String title,
                          final String employeeOnlyText,
                          final String status) {
        final Sample sample = new Sample();
        sample.setTitle(title);
        sample.setEmployeeOnlyText(employeeOnlyText);
        sample.setStatus(sampleStatusRepository.findById(status));
        return sample;
    }
}
