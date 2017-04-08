package ru.tsystems.tchallenge.service.kernel.domain.account;

public interface AccountService {

    AccountInfo create(AccountInvoice accountProperties);

    AccountInfo getByLogin(String login);

    AccountInfo updateEmail(String login, String newEmail);

    AccountInfo updateLogin(String login, String newLogin);

    AccountInfo updateSecret(String login, String newSecret);

    AccountInfo updateStatus(String login, String newStatus);
}
