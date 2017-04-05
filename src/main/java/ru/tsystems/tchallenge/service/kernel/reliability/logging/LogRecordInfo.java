package ru.tsystems.tchallenge.service.kernel.reliability.logging;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class LogRecordInfo extends GenericInfo {

    private final String id;
    private final String correlation;

    public LogRecordInfo(final String id, final String correlation) {
        this.id = id;
        this.correlation = correlation;
    }
}
