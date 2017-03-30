package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;

public class SystemInfo {

    private AccountInfo account;
    private String title;
    private String description;
    private Collection<String> roles;

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
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

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }
}
