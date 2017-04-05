package ru.tsystems.tchallenge.service.kernel.reliability.logging;

public final class LogRecordInvoice {

    private LogRecordChannel channel;
    private LogRecordLevel level;
    private String message;
    private Object payload;
    private Throwable throwable;

    public LogRecordChannel getChannel() {
        return channel;
    }

    public void setChannel(LogRecordChannel channel) {
        this.channel = channel;
    }

    public LogRecordLevel getLevel() {
        return level;
    }

    public void setLevel(LogRecordLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
