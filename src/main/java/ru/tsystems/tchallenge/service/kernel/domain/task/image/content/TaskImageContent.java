package ru.tsystems.tchallenge.service.kernel.domain.task.image.content;

import javax.persistence.Column;
import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class TaskImageContent extends CasualEntity {

    @Column
    private byte[] binaryData;

    public byte[] getBinaryData() {
        return binaryData;
    }

    public void setBinaryData(final byte[] binaryData) {
        this.binaryData = binaryData;
    }
}
