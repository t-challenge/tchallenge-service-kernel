package ru.tsystems.tchallenge.service.kernel.generic.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EnumeratedEntity extends GenericEntity<String> {

    @Id
    @Column
    private String id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Integer stance;

    @Override
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getStance() {
        return stance;
    }

    public void setStance(final Integer stance) {
        this.stance = stance;
    }
}
