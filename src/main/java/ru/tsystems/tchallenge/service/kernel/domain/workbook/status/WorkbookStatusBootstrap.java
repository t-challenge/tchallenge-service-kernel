package ru.tsystems.tchallenge.service.kernel.domain.workbook.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class WorkbookStatusBootstrap extends EnumeratedEntityBootstrap<WorkbookStatus> {

    @Autowired
    private WorkbookStatusRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CREATED");
        ids.add("SUBMITTED");
        ids.add("ASSESSED");
        ids.add("DISCARDED");
        ids.add("DELETED");
    }

    @Override
    protected WorkbookStatus enumerated(final String id) {
        return new WorkbookStatus(id);
    }

    @Override
    protected GenericEntityRepository<WorkbookStatus, String> getRepository() {
        return repository;
    }
}
