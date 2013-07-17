package ru.t_systems.demail.controllers.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import ru.t_systems.demail.controllers.models.AccountForm;
import ru.t_systems.demail.service.AccountService;

@Component("accountProfileValidator")
public class AccountFormValidation {

    @Autowired
    private AccountService accountService;

    public boolean supports(Class<?> klass) {
        return AccountForm.class.isAssignableFrom(klass);

    }

    public void validate(Object target, Errors errors) {
        AccountForm accountProfile = (AccountForm) target;

        if (accountService.getAccountByName(accountProfile.getNewaccount()) != null) {
            errors.rejectValue("newaccount",
                    "account.profile.newaccount",
                    "Account alredy registred.");
        }


    }

}
