package ru.t_systems.demail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.dao.account.AccountDAO;
import ru.t_systems.demail.model.user.Account;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public Account getAccountByName(String login) {

        return accountDAO.getAccountByname(login);
    }

    public Account getAccountById(int id) {

        return accountDAO.getAccount(id);
    }


}
