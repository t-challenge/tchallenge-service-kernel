package ru.tsystems.tchallenge.service.kernel.domain.sample;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.sample.status.SampleStatus;
import ru.tsystems.tchallenge.service.kernel.domain.sample.status.SampleStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

@FacadeService
public class EmployeeSampleFacadeBean extends GenericFacade implements EmployeeSampleFacade {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SampleStatusRepository sampleStatusRepository;

    @Autowired
    private EmployeeSampleMapper sampleMapper;

    @Override
    public EmployeeSampleInfo create(final EmployeeSampleInvoice invoice) {
        return saveAndInfo(fromInvoice(invoice));
    }

    @Override
    public EmployeeSampleInfo get(final Long id) {
        return info(byId(id));
    }

    @Override
    public SearchInfo<EmployeeSampleInfo> getPage(final EmployeeSamplePageInvoice invoice) {
        final PageRequest pageRequest = new PageRequest(invoice.getStance() - 1, invoice.getSize());
        final Page<Sample> page = sampleRepository
                .findPage("%" + invoice.getTitle() + "%", invoice.getStatus(), pageRequest);
        final SearchInfo<EmployeeSampleInfo> pageInfo = new SearchInfo<>();
        pageInfo.setItems(page.getContent().stream().map(this::info).collect(Collectors.toList()));
        pageInfo.setTotal(page.getTotalPages());
        pageInfo.setSize(invoice.getSize());
        pageInfo.setSerial(invoice.getStance());
        return pageInfo;
    }

    @Override
    public EmployeeSampleInfo update(final EmployeeSampleUpdateInvoice invoice) {
        return saveAndInfo(mergeInvoice(byId(invoice.getId()), invoice));
    }

    private Sample fromInvoice(final EmployeeSampleInvoice invoice) {
        final Sample sample = new Sample();
        sample.setTitle(invoice.getTitle());
        sample.setEmployeeOnlyText(invoice.getEmployeeOnlyText());
        sample.setStatus(status("CREATED"));
        return sample;
    }

    private Sample mergeInvoice(final Sample sample, final EmployeeSampleUpdateInvoice invoice) {
        sample.setTitle(invoice.getTitle());
        sample.setEmployeeOnlyText(invoice.getEmployeeOnlyText());
        sample.setStatus(status(invoice.getStatus()));
        return sample;
    }

    private Sample byId(final Long id) {
        return sampleRepository.findById(id);
    }

    private EmployeeSampleInfo info(final Sample sample) {
        return sampleMapper.info(sample);
    }

    private EmployeeSampleInfo saveAndInfo(final Sample sample) {
        return info(sampleRepository.save(sample));
    }

    private SampleStatus status(final String id) {
        return sampleStatusRepository.findById(id);
    }
}
