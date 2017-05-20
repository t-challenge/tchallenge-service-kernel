package ru.tsystems.tchallenge.service.kernel.generic;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericInvoice implements Serializable {

    private Collection<String> updatedProperties;

    public Collection<String> getUpdatedProperties() {
        return updatedProperties;
    }

    public void setUpdatedProperties(final Collection<String> updatedProperties) {
        this.updatedProperties = updatedProperties;
    }
}
