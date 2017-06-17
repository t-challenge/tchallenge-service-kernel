package ru.tchallenge.service.kernel.generic;

public final class EnumeratedInfo extends GenericInfo implements WithStance {

    private final String id;
    private final String title;
    private final String description;
    private final Integer stance;

    public EnumeratedInfo(final String id,
                          final String title,
                          final String description,
                          final Integer stance) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.stance = stance;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Integer getStance() {
        return stance;
    }
}
