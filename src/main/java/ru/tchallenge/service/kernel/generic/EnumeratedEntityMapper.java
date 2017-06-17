package ru.tchallenge.service.kernel.generic;

import ru.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

public abstract class EnumeratedEntityMapper<T extends EnumeratedEntity> extends GenericMapper {

    public T asEntity(final EnumeratedInvoice invoice) {
        final T entity = enumeratedEntity();
        entity.setId(invoice.getId());
        entity.setTitle(invoice.getTitle());
        entity.setDescription(invoice.getDescription());
        entity.setStance(invoice.getStance());
        return entity;
    }

    public EnumeratedInfo asInfo(final T entity) {
        return new EnumeratedInfo(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStance());
    }

    protected abstract T enumeratedEntity();
}
