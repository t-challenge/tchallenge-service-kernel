package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskSelectionInvoice extends GenericInvoice {

    private Integer amount;
    private Collection<String> categories;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }
}
