package ru.tchallenge.service.kernel.domain.event;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import ru.tchallenge.service.kernel.domain.forum.ForumInfo;
import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class EventInfo extends GenericInfo {

    private final String textcode;
    private final String title;
    private final String description;
    private final String greeting;
    private final String notification;
    private final String status;
    private final String maturity;
    private final Collection<String> specializations;
    private final Instant since;
    private final Instant until;
    private final ForumInfo forum;

    public EventInfo(final String textcode,
                     final String title,
                     final String description,
                     final String greeting,
                     final String notification,
                     final String status,
                     final String maturity,
                     final Collection<String> specializations,
                     final Instant since,
                     final Instant until,
                     final ForumInfo forum) {
        this.textcode = textcode;
        this.title = title;
        this.description = description;
        this.greeting = greeting;
        this.notification = notification;
        this.status = status;
        this.maturity = maturity;
        this.specializations = new ArrayList<>(specializations);
        this.since = since;
        this.until = until;
        this.forum = forum;
    }

    public String getTextcode() {
        return textcode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getNotification() {
        return notification;
    }

    public String getStatus() {
        return status;
    }

    public String getMaturity() {
        return maturity;
    }

    public Collection<String> getSpecializations() {
        return new ArrayList<>(specializations);
    }

    public Instant getSince() {
        return since;
    }

    public Instant getUntil() {
        return until;
    }

    public ForumInfo getForum() {
        return forum;
    }
}
