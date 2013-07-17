package ru.t_systems.demail.dao.account;

import ru.t_systems.demail.model.user.Account;

public interface AccountDAO {

    public Account getAccount(int id);

    public Account getAccountByname(String account);
}
