package ru.t_systems.demail.controllers.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.t_systems.demail.model.user.Account;
import ru.t_systems.demail.service.AccountService;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

@Component
public class AccountStringListEditor extends PropertyEditorSupport {

    @Autowired
    private AccountService accountService;

    @Override
    public String getAsText() {
        Set<Account> acSet = (Set<Account>) getValue();
        StringBuilder builder = new StringBuilder();
        // String value = new String();
        if (acSet != null) {
            for (Account account : acSet) {
                builder.append(account.getAccountName());
                builder.append(";");
            }
        }
        return builder.toString();

    }

    @Override
    public void setAsText(final String text) {
        Set<Account> acSet = new HashSet<Account>();
        String[] accounts = text.split("\\;|\\,|\\s");
        // System.out.println("----- Account sender aray = " + accounts.length);
        for (String account : accounts) {
            Account ac = null;
            if (!account.isEmpty()) {
                ac = accountService.getAccountByName(account.trim());
            }
            // System.out.println("Account name = '" + account + "'");
            if (ac != null) {
                acSet.add(ac);
            }
        }
        // System.out.println("----- Account sender aray1 = " + acSet.size());
        setValue(acSet);

    }

}
