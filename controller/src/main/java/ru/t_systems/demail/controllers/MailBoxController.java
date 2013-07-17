
package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.t_systems.demail.model.message.Label;
import ru.t_systems.demail.model.message.MessageStatuss;
import ru.t_systems.demail.model.user.Account;
import ru.t_systems.demail.model.user.User;
import ru.t_systems.demail.service.UserService;
import ru.t_systems.demail.service.message.MessageStatusService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MailBoxController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageStatusService messageStatusService;

    @RequestMapping(value = URL.MAILBOX + "/{accountId}", method = RequestMethod.GET)
    public ModelAndView mailBoxControllerAccount(
            @PathVariable String accountId, HttpServletRequest request) {
        Integer id;
        List<Integer> ids = new ArrayList<Integer>();

        try {
            id = Integer.parseInt(accountId);
        } catch (Exception e) {
            id = null;
        }

        User user = userService.getUser(SecurityContextHolder.getContext()
                .getAuthentication().getName());
      //  user.getAccounts();

        if (id == null) {
            return new ModelAndView(URL.MAILBOX_JSP);

        } else {
            ids.add(id);
        }

        return mailBox(request, ids, 50);
    }

    @RequestMapping(value = URL.MAILBOX, method = RequestMethod.GET)
    public ModelAndView mailBoxController(HttpServletRequest request) {
        List<Integer> ids = new ArrayList<Integer>();

        User user = userService.getUser(SecurityContextHolder.getContext()
                .getAuthentication().getName());
        for (Account account : user.getAccounts()) {
            ids.add(account.getId());
        }


        return mailBox(request, ids, 50);
    }

    private ModelAndView mailBox(HttpServletRequest request,
                                 List<Integer> accountId, Integer limit) {
        ModelAndView model = new ModelAndView(URL.MAILBOX_JSP);
        Set<MessageStatuss> status = new TreeSet<MessageStatuss>(
                Collections.reverseOrder());

        System.out.println("Input Status count = "
                + messageStatusService.getInputStatusCount(Arrays.asList(1)));

        String box = new String();
        Integer page;

        if (request.getParameter("box") != null) {
            box = request.getParameter("box");
        }

        if (request.getParameter("page") != null) {
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                page = 0;
            }

        } else {
            page = 0;
        }

        for (Iterator<Integer> id = accountId.iterator(); id.hasNext(); ) {
            if (box.equals(URL.MAILBOXOUTPUT)) {
                status.addAll(messageStatusService.getOutputStatus(id.next(),
                        limit, limit * page));
            } else if (box.equals(URL.MAILBOXSPAM)) {
                status.addAll(messageStatusService.getSpamStatus(id.next(),
                        limit, limit * page));
            } else if (box.equals(URL.MAILBOXTRASH)) {
                status.addAll(messageStatusService.getTrashStatus(id.next(),
                        limit, limit * page));
            } else {

                if (!box.isEmpty()) {
                    Integer labelid = null;
                    try {
                        labelid = Integer.parseInt(box);
                    } catch (Exception e) {

                    }

                    if (labelid != null) {
                        status.addAll(messageStatusService
                                .getInputStatusFromLabel(id.next(), labelid,
                                        limit, limit * page));
                    } else {

                        status.addAll(messageStatusService.getInputStatus(
                                id.next(), limit, limit * page));
                    }
                } else {
                    status.addAll(messageStatusService.getInputStatus(
                            id.next(), limit, limit * page));
                }
            }
        }
        if (accountId.size() == 1) {
            model.addObject("selectAccount", accountId.get(0));
        }
        model.addObject("status", status);
        return model;
    }

    @ModelAttribute("accounts")
    public Set<Account> genderList() {

        User user = userService.getUser(SecurityContextHolder.getContext()
                .getAuthentication().getName());

        return user.getAccounts();
    }

    @ModelAttribute("labels")
    public List<Label> labelList() {

        List<Label> list = new ArrayList<Label>();

        for (Account account : genderList()) {
            list.addAll(account.getLabel());
        }

        return list;
    }

}
