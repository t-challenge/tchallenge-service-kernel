package ru.tchallenge.service.kernel.generic;

public abstract class GenericMapper extends GenericService {

    protected Boolean flag(final Integer flag) {
        return flag != null && flag != 0;
    }

    protected Integer flag(final Boolean flag) {
        return flag != null && flag ? 1 : 0;
    }
}
