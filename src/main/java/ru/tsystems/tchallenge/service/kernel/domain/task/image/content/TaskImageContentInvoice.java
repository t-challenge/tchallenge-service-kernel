package ru.tsystems.tchallenge.service.kernel.domain.task.image.content;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskImageContentInvoice extends GenericInvoice {

    private byte[] binaryData;

    public byte[] getBinaryData() {
        return binaryData;
    }

    public void setBinaryData(final byte[] binaryData) {
        this.binaryData = binaryData;
    }
}
