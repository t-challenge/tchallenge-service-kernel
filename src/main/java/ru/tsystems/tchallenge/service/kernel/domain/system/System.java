package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.shared.SubsequentEntity;
import ru.tsystems.tchallenge.service.kernel.domain.system.role.SystemRole;

@Entity
public class System extends SubsequentEntity {

    @OneToOne
    private Account account;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToMany
    private Collection<SystemRole> roles = new ArrayList<>();

    public System(Long id) {
        super(id);
    }

    protected System() {

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<SystemRole> getRoles() {
        return roles;
    }
}
