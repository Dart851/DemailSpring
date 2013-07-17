//package ru.t_systems.demail.controllers;
//
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import ru.t_systems.demail.controllers.editors.AccountEditor;
//import ru.t_systems.demail.controllers.editors.AccountStringListEditor;
//import ru.t_systems.demail.controllers.models.CreateMessageForm;
//import ru.t_systems.demail.model.message.MessageStatuss;
//import ru.t_systems.demail.model.user.Account;
//import ru.t_systems.demail.service.UserService;
//import ru.t_systems.demail.service.message.MessageService;
//import ru.t_systems.demail.service.message.MessageStatusService;
//
//@Controller
//public class OpenMessageMenuController {
//
//	@Autowired
//	MessageStatusService messageStatusService;
//
//	@Autowired
//	private AccountEditor accountEditor;
//
//	@Autowired
//	private AccountStringListEditor accountStringEditor;
//
//	@Autowired
//	private MessageService messageService;
//
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value = URL.MAILREPLY + "{statusId}", method = RequestMethod.GET)
//	public ModelAndView reMessage(@PathVariable String statusId) {
//
//		int id;
//		try {
//			id = Integer.parseInt(statusId);
//		} catch (Exception e) {
//			return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
//		}
//		MessageStatuss message = messageStatusService.getMessageStatus(id);
//		if (message == null) {
//			return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
//		}
//
//		return new ModelAndView(URL.NEWMAIL_JSP, "newMail",
//				new CreateMessageForm(message));
//	}
//
//	@RequestMapping(value = URL.MAILREPLY + "{statusId}", method = RequestMethod.POST)
//	public ModelAndView reMessagePost(
//			@ModelAttribute("newMail") @Valid CreateMessageForm newMail,
//			BindingResult result) {
//
//		System.out.println("----- POSt");
//		messageService.addMessage(newMail.toMessage());
//		return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
//	}
//
//	@RequestMapping(value = URL.MAILDELETE + "{statusId}", method = RequestMethod.GET)
//	public ModelAndView deleteMessage(@PathVariable String statusId,
//			HttpServletRequest request) {
//		int id;
//		try {
//			id = Integer.parseInt(statusId);
//		} catch (Exception e) {
//			return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
//		}
//		CreateMessageForm forwardedObj = (CreateMessageForm) request
//				.getAttribute("newMail");
//		System.out.println("---------Mesage delete" + forwardedObj.getTitle());
//		MessageStatuss status = messageStatusService.getMessageStatus(id);
//		status.setIsDeleted(true);
//		// messageStatusService.update(status);
//		return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
//	}
//
//	@ModelAttribute("accounts")
//	public Set<Account> accountsList() {
//
//		return userService.getUser(
//				SecurityContextHolder.getContext().getAuthentication()
//						.getName()).getAccounts();
//
//	}
//
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(Account.class, "accountSender",
//				accountEditor);
//	}
//
//	@InitBinder
//	public void initBinder1(WebDataBinder binder) {
//		binder.registerCustomEditor(Set.class, "accounts", accountStringEditor);
//	}
//
//}
