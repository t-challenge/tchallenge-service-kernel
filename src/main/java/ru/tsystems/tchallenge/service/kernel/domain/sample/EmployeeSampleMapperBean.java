package ru.tsystems.tchallenge.service.kernel.domain.sample;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class EmployeeSampleMapperBean extends GenericMapper implements EmployeeSampleMapper {

    @Override
    public EmployeeSampleInfo info(final Sample sample) {
        final EmployeeSampleInfo info = new EmployeeSampleInfo();
        info.setId(sample.getId());
        info.setTitle(sample.getTitle());
        info.setEmployeeOnlyText(sample.getEmployeeOnlyText());
        info.setStatus(sample.getStatus().getId());
        return info;
    }
}
