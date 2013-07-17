package ru.t_systems.demail.controllers.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.t_systems.demail.service.AccountService;

import java.beans.PropertyEditorSupport;

@Component
public class AccountEditor extends PropertyEditorSupport {

    @Autowired
    private AccountService accountService;

    @Override
    public void setAsText(final String text) {

        System.out.println("-----------------OLOLOOOLO");
        if (!text.equals("NONE") && !text.isEmpty()) {
            setValue(accountService.getAccountById(Integer.valueOf(text)));
        }
    }

}
