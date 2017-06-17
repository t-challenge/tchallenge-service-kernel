package ru.tchallenge.service.kernel.domain.robot;

import java.util.Collection;

import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class RobotInfo extends GenericInfo {

    private String title;
    private String description;
    private Collection<String> roles;

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

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<String> roles) {
        this.roles = roles;
    }
}
