package ru.tsystems.tchallenge.service.kernel.domain.task.difficulty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskDifficultyBootstrap extends EnumeratedEntityBootstrap<TaskDifficulty> {

    @Autowired
    private EnumeratedEntityMapper<TaskDifficulty> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskDifficulty> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("ELEMENTARY", "Очень простой"));
        invoices.add(enumerated("EASY", "Простой"));
        invoices.add(enumerated("MEDIUM", "Умеренный"));
        invoices.add(enumerated("HARD", "Сложный"));
        invoices.add(enumerated("ULTIMATE", "Очень сложный", "Задачи, требующие экспертного понимая предмета"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskDifficulty> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskDifficulty> getRepository() {
        return repository;
    }
}
