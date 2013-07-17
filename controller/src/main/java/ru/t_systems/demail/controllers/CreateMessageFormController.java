package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.t_systems.demail.controllers.editors.AccountEditor;
import ru.t_systems.demail.controllers.editors.AccountStringListEditor;
import ru.t_systems.demail.controllers.models.CreateMessageForm;
import ru.t_systems.demail.model.user.Account;
import ru.t_systems.demail.service.UserService;
import ru.t_systems.demail.service.message.MessageService;
import ru.t_systems.demail.service.message.MessageStatusService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = URL.NEWMAIL)
public class CreateMessageFormController {

    @Autowired
    private AccountEditor accountEditor;
    @Autowired
    private AccountStringListEditor accountStringEditor;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageStatusService messageStatusService;
    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegistration(HttpServletRequest request,
                                         Map<String, CreateMessageForm> model,
                                         @ModelAttribute("newMail") @Valid CreateMessageForm newMail) {

        if (newMail != null) {
            newMail = new CreateMessageForm();
        }
        model.put("newMail", newMail);
        return new ModelAndView(URL.NEWMAIL_JSP);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processRegistration(
            @ModelAttribute("newMail") @Valid CreateMessageForm newMail,
            BindingResult result) {
        System.out.println("----- POSt");
        messageService.addMessage(newMail.toMessage());
        return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
    }

    @ModelAttribute("accounts")
    public Set<Account> accountsList() {

        return userService.getUser(
                SecurityContextHolder.getContext().getAuthentication()
                        .getName()).getAccounts();

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Account.class, "accountSender",
                accountEditor);
    }

    @InitBinder
    public void initBinder1(WebDataBinder binder) {

        binder.registerCustomEditor(Set.class, "accounts", accountStringEditor);

    }

}
