package ru.tsystems.tchallenge.service.kernel.domain.event;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.event.category.EventCategory;
import ru.tsystems.tchallenge.service.kernel.domain.event.status.EventStatus;
import ru.tsystems.tchallenge.service.kernel.domain.forum.Forum;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Event extends SequentialEntity {

    @Column
    private String textcode;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String greeting;

    @ManyToOne
    private EventCategory category;

    @ManyToOne
    private EventStatus status;

    @ManyToOne
    private Maturity maturity;

    @ManyToMany
    private Collection<Specialization> specializations = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Forum forum;

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(final String textcode) {
        this.textcode = textcode;
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

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(final String greeting) {
        this.greeting = greeting;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(final EventCategory category) {
        this.category = category;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(final EventStatus status) {
        this.status = status;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }

    public Collection<Specialization> getSpecializations() {
        return specializations;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(final Forum forum) {
        forum.setEvent(this);
        this.forum = forum;
    }
}
