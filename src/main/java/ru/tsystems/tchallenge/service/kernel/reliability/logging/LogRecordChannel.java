package ru.tsystems.tchallenge.service.kernel.reliability.logging;

public enum LogRecordChannel {

    COMMON("common"),

    SECURITY("security");

    private static final String PREFIX = "ru.tsystems.tchallenge.service.kernel";

    private final String textcode;

    LogRecordChannel(final String suffix) {
        this.textcode = String.format("%s.%s", PREFIX, suffix);
    }

    public String getTextcode() {
        return textcode;
    }
}
