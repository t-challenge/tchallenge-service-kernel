package ru.tchallenge.service.kernel.domain.robot;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ru.tchallenge.service.kernel.domain.account.Account;
import ru.tchallenge.service.kernel.domain.robot.role.RobotRole;
import ru.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Robot extends SequentialEntity {

    @OneToOne
    private Account account;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToMany
    private Collection<RobotRole> roles = new ArrayList<>();

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
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

    public Collection<RobotRole> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<RobotRole> roles) {
        this.roles = roles;
    }
}
