package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class EmployeeRoleBootstrap extends EnumeratedEntityBootstrap<EmployeeRole> {

    @Autowired
    private EnumeratedEntityMapper<EmployeeRole> mapper;

    @Autowired
    private EnumeratedEntityRepository<EmployeeRole> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("ADMIN", "Администратор"));
        invoices.add(enumerated("USERMOD", "Модератор учетных записей"));
        invoices.add(enumerated("TASKVIEW", "Просмотрщик задач"));
        invoices.add(enumerated("TASKMOD", "Модератор задач"));
        invoices.add(enumerated("EVENTVIEW", "Просмотрщик событий"));
        invoices.add(enumerated("EVENTMOD", "Модератор событий"));
        invoices.add(enumerated("CANDVIEW", "Просмотрщик кандидатов"));
        invoices.add(enumerated("CANDMOD", "Модератор кандидатов"));
        invoices.add(enumerated("WBKVIEW", "Просмотрщик тетрадей"));
    }

    @Override
    protected EnumeratedEntityMapper<EmployeeRole> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<EmployeeRole> getRepository() {
        return repository;
    }
}
