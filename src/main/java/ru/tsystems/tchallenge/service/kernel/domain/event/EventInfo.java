package ru.tsystems.tchallenge.service.kernel.domain.event;

import java.util.ArrayList;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.forum.ForumInfo;
import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class EventInfo extends GenericInfo {

    private final String textcode;
    private final String title;
    private final String description;
    private final String greeting;
    private final String status;
    private final Collection<String> maturities;
    private final Collection<String> specializations;
    private final ForumInfo forum;

    public EventInfo(final String textcode,
                     final String title,
                     final String description,
                     final String greeting,
                     final String status,
                     final Collection<String> maturities,
                     final Collection<String> specializations,
                     final ForumInfo forum) {
        this.textcode = textcode;
        this.title = title;
        this.description = description;
        this.greeting = greeting;
        this.status = status;
        this.maturities = new ArrayList<>(maturities);
        this.specializations = new ArrayList<>(specializations);
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

    public String getStatus() {
        return status;
    }

    public Collection<String> getMaturities() {
        return new ArrayList<>(maturities);
    }

    public Collection<String> getSpecializations() {
        return new ArrayList<>(specializations);
    }

    public ForumInfo getForum() {
        return forum;
    }
}
