package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.time.Instant;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class GenericMapper {

    protected String enumeratedId(EnumeratedEntity entity) {
        return entity.getId();
    }

    protected Boolean flag(Integer flag) {
        return flag != null && flag != 0;
    }

    protected Integer flag(Boolean flag) {
        return flag != null && flag ? 1 : 0;
    }

    protected String timestamp(Instant instant) {
        return instant.toString();
    }
}
