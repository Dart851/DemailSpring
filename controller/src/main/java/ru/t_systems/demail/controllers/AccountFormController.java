package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.t_systems.demail.controllers.editors.CountryEditor;
import ru.t_systems.demail.controllers.models.AccountForm;
import ru.t_systems.demail.controllers.validations.AccountFormValidation;
import ru.t_systems.demail.model.user.Account;
import ru.t_systems.demail.model.user.Country;
import ru.t_systems.demail.model.user.User;
import ru.t_systems.demail.service.CountryService;
import ru.t_systems.demail.service.RoleService;
import ru.t_systems.demail.service.UserService;
import ru.t_systems.demail.service.message.MessageService;
import ru.t_systems.demail.service.message.MessageStatusService;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/mail/account.html")
@SessionAttributes(value = "accountList")
public class AccountFormController {
    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    protected AuthenticationManager authenticationManager;
    @Autowired
    private CountryEditor countryEditor;
    @Autowired
    private AccountFormValidation accountFormValidation;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private MessageStatusService messageStatuss;
    @Autowired
    private MessageService messageService;

    @ModelAttribute("accountList")
    public Set<Account> getAllUserAccount() {

        return userService.getUser(
                SecurityContextHolder.getContext().getAuthentication()
                        .getName()).getAccounts();
    }

    // Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showEditProfile(Map<String, AccountForm> model) {

        AccountForm accoutProfile = new AccountForm();
        model.put("account", accoutProfile);

        return "accountform";
    }

    // Process the form.
    @RequestMapping(method = RequestMethod.POST)
    public String processEditProfile(
            @ModelAttribute("account") @Valid AccountForm accountProfile,
            @ModelAttribute("accountList") Set<Account> accountList,
            BindingResult result) {

        accountFormValidation.validate(accountProfile, result);

        if (result.hasErrors()) {

            return "accountform";

        } else {
            User user = userService.getUser(SecurityContextHolder.getContext()
                    .getAuthentication().getName());

            Account account = new Account();

            account.setAccountName(accountProfile.getNewaccount());

            user.getAccounts().add(account);

            userService.update(user);
            accountList.add(account);
            accountProfile.setNewaccount("");

        }

        return "accountform";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Country.class, countryEditor);
    }

}
