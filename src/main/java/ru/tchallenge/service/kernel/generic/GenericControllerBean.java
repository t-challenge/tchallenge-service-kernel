package ru.tchallenge.service.kernel.generic;

public abstract class GenericControllerBean {

    protected <T> T normalize(final T invoice, final T defaultValue) {
        return invoice != null ? invoice : defaultValue;
    }
}
