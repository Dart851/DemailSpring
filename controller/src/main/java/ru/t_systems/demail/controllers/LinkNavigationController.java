package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.t_systems.demail.model.message.Label;
import ru.t_systems.demail.model.message.Message;
import ru.t_systems.demail.model.message.MessageStatuss;
import ru.t_systems.demail.model.user.Account;
import ru.t_systems.demail.model.user.Role;
import ru.t_systems.demail.model.user.User;
import ru.t_systems.demail.service.RoleService;
import ru.t_systems.demail.service.UserService;
import ru.t_systems.demail.service.message.MessageService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LinkNavigationController {

    @Autowired
    UserService userService;
    RoleService roleService;
    @Autowired
    MessageService messageService;

    // @PreAuthorize("isFullyAuthenticated()")
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/mail/index", method = RequestMethod.GET)
    public ModelAndView moderatorPage() {
        return new ModelAndView("mail-main");
    }

    @RequestMapping(value = "/admin/first", method = RequestMethod.GET)
    public ModelAndView firstAdminPage() {
        return new ModelAndView("admin-first");
    }

    @RequestMapping(value = "/admin/second", method = RequestMethod.GET)
    public ModelAndView secondAdminPage() {
        return new ModelAndView("admin-second");
    }

    @RequestMapping(value = "/403.html", method = RequestMethod.GET)
    public ModelAndView page403() {
        return new ModelAndView("403");
    }

    @RequestMapping(value = "/404.html", method = RequestMethod.GET)
    public ModelAndView page404() {
        return new ModelAndView("404");
    }

    @RequestMapping(value = "/inline.html", method = RequestMethod.GET)
    public ModelAndView pageInline() {


        return new ModelAndView("inline");
    }


//	@RequestMapping(value = "/mail/mail-box/show-mail.html", method = RequestMethod.GET)
//	public ModelAndView mailShow(HttpServletRequest request,
//			HttpServletResponse response) {
//
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		User user = userService.getUser(SecurityContextHolder.getContext()
//				.getAuthentication().getName());
//		user.getAccounts();
//		Set<MessageStatuss> status = new HashSet<MessageStatuss>();
//
//		for (Iterator<Account> iterator = user.getAccounts().iterator(); iterator
//				.hasNext();) {
//			Account account = (Account) iterator.next();
//			if (account.getId().equals(id)) {
//				status.addAll(account.getStatus());
//			}
//		}
//		ModelAndView model = new ModelAndView("showMail");
//		model.addObject("status", status);
//
//		return model;
//	}

    @RequestMapping(value = "/install.html", method = RequestMethod.GET)
    public ModelAndView install() {
        if (userService.getUser("admin") == null) {
            Role role = new Role();
            User user = new User();
            user.setLogin("admin");
            user.setPassword("111111");
            role.setRole("admin");
            user.setRole(role);

            Account account = new Account();
            account.setAccountName("admin@de-mail.de");

            Account account1 = new Account();
            account1.setAccountName("admin1@de-mail.de");

            Label lab = new Label();

            Label lab1 = new Label();

            lab.setName("folder1");
            lab1.setName("folder11");

            Set<Account> set = new HashSet<Account>();
            Set<Label> label = new HashSet<Label>();
            label.add(lab);
            label.add(lab1);

            Set<Label> label1 = new HashSet<Label>();
            label1.add(lab);
            label1.add(lab1);

            account.setLabel(label);
            account1.setLabel(label);
            set.add(account);
            set.add(account1);
            user.setAccounts(set);

            Message message = new Message();
            message.setBody("test");
            message.setTitle("Привет мир");
            MessageStatuss messageStatuss = new MessageStatuss();
            messageStatuss.setAccount(account);
            messageStatuss.setAcountsSender(account);
            messageStatuss.setLabel(lab);

            MessageStatuss messageStatuss1 = new MessageStatuss();
            messageStatuss1.setAccount(account1);
            messageStatuss1.setAcountsSender(account);
            messageStatuss.setLabel(lab1);
            List<MessageStatuss> list = new ArrayList<MessageStatuss>();

            list.add(messageStatuss);
            list.add(messageStatuss1);
            message.setStatus(list);

            userService.addUser(user);
            messageService.addMessage(message);

            Label lab2 = new Label();
            Set<Label> ll = new HashSet<Label>();

            lab2.setName("folder3");
            ll.add(lab2);

            account.getLabel().add(lab2);

            Role roleUser = new Role();

            User user1 = new User();
            user1.setLogin("user");
            user1.setPassword("111111");
            roleUser.setRole("user");
            user1.setRole(roleUser);
            userService.addUser(user1);

            // userService.deleteUser(user);

            return new ModelAndView("install");
        }
        return new ModelAndView("user-login");
    }

}
