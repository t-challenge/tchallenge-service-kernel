package ru.tchallenge.service.kernel.generic.bootstrap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

public abstract class EnumeratedEntityBootstrap<E extends EnumeratedEntity> extends GenericEntityBootstrap<E, String> {

    @Override
    protected void collectEntities(final Collection<E> entities) {
        invoices().stream().map(getMapper()::asEntity).forEach(entities::add);
    }

    protected abstract EnumeratedEntityMapper<E> getMapper();

    protected abstract void collectInvoices(final Collection<EnumeratedInvoice> invoices);

    protected EnumeratedInvoice enumerated(String id, String title) {
        return enumerated(id, title, null);
    }

    protected EnumeratedInvoice enumerated(String id, String title, String description) {
        final EnumeratedInvoice invoice = new EnumeratedInvoice();
        invoice.setId(id);
        invoice.setTitle(title);
        invoice.setDescription(description);
        return invoice;
    }

    private Collection<EnumeratedInvoice> invoices() {
        List<EnumeratedInvoice> invoices = new ArrayList<>();
        collectInvoices(invoices);
        invoices.forEach(invoice -> invoice.setStance(invoices.indexOf(invoice) + 1));
        return invoices;
    }
}
