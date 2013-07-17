package ru.t_systems.demail.service;

import ru.t_systems.demail.model.user.Account;

public interface AccountService {

    public Account getAccountByName(String login);

    public Account getAccountById(int id);
}
