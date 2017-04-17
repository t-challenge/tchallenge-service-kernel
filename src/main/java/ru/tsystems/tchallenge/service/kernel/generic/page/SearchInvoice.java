package ru.tsystems.tchallenge.service.kernel.generic.page;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public abstract class SearchInvoice extends GenericInvoice {

    private Integer size;
    private Integer stance;

    public Integer getSize() {
        return size;
    }

    public void setSize(final Integer size) {
        this.size = size;
    }

    public Integer getStance() {
        return stance;
    }

    public void setStance(final Integer stance) {
        this.stance = stance;
    }
}
