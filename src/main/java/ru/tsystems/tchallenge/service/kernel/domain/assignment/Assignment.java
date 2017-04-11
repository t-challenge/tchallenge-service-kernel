package ru.tsystems.tchallenge.service.kernel.domain.assignment;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ru.tsystems.tchallenge.service.kernel.domain.task.Task;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.Workbook;
import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class Assignment extends CasualEntity {

    @Column
    private String input;

    @Column
    private Integer stance;

    @ManyToOne
    private Task task;

    @ManyToOne
    private Workbook workbook;
}
