package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.t_systems.demail.controllers.editors.AccountEditor;
import ru.t_systems.demail.controllers.editors.AccountStringListEditor;
import ru.t_systems.demail.controllers.editors.LabelEditor;
import ru.t_systems.demail.controllers.models.CreateMessageForm;
import ru.t_systems.demail.model.message.DeletStatus;
import ru.t_systems.demail.model.message.Label;
import ru.t_systems.demail.model.message.MessageStatuss;
import ru.t_systems.demail.model.user.Account;
import ru.t_systems.demail.model.user.User;
import ru.t_systems.demail.service.AccountService;
import ru.t_systems.demail.service.UserService;
import ru.t_systems.demail.service.message.MessageService;
import ru.t_systems.demail.service.message.MessageStatusService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = URL.OPENMAIL)
@SessionAttributes("newMail")
public class OpenMessageFormController {
	/*
	 * @Autowired private CountryEditor countryEditor;
	 */

	// @Autowired
	// private RegistrationValidation registrationValidation;

	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageStatusService messageStatusService;
	@Autowired
	private AccountEditor accountEditor;
	@Autowired
	private AccountStringListEditor accountStringEditor;
	@Autowired
	private LabelEditor lableEditor;
	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRegistration(HttpServletRequest request) {

		Integer id = null;

		if (request.getParameter("id") != null
				&& !request.getParameter("id").isEmpty()) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				id = null;

			}

		}
		if (id == null) {
			return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
		}
		/*
		 * User user = userService.getUser(SecurityContextHolder.getContext()
		 * .getAuthentication().getName()); // user.getAccounts();
		 */
		MessageStatuss status = messageStatusService.getMessageStatus(id);
		status.setIsRead(true);

		System.out.println("-------------------LABEL = " + status.getLabel());

		messageStatusService.update(status);

		CreateMessageForm message = new CreateMessageForm(status);

		message.setBody(message.getBody());

		ModelAndView model = new ModelAndView(URL.OPENMAIL_JSP);
		model.addObject("status", status);
		model.addObject("newMail", message);
		List<MessageStatuss> messageStatus = status.getMessage().getStatus();
		model.addObject("mailList", messageStatus);

		return model;
	}

	@RequestMapping(method = RequestMethod.POST, params = "submitButton=FastReply")
	public ModelAndView fastReply(
			@ModelAttribute("newMail") @Valid CreateMessageForm newMail) {
		newMail.setTitle("RE:" + newMail.getTitle());
		newMail.setBody("<br><blockquote>" + newMail.getBody()
				+ "</blockquote>");
		messageService.addMessage(newMail.toMessage());
		return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
	}

	@RequestMapping(method = RequestMethod.POST, params = "submitButton=Reply")
	public ModelAndView reply(
			@ModelAttribute("newMail") @Valid CreateMessageForm newMail) {
		newMail.setTitle("RE:" + newMail.getTitle());
		newMail.setBody("<br><blockquote>" + newMail.getBody()
				+ "</blockquote>");
		newMail.setBodyFast("");
		return new ModelAndView(URL.NEWMAIL_JSP);
	}

	@RequestMapping(method = RequestMethod.POST, params = "submitButton=Forward")
	public ModelAndView forward(
			@ModelAttribute("newMail") @Valid CreateMessageForm newMail) {
		newMail.setTitle("FWD:" + newMail.getTitle());
		newMail.setBody("<br><blockquote>" + newMail.getBody()
				+ "</blockquote>");
		newMail.setBodyFast("");
		newMail.setAccounts(null);
		return new ModelAndView(URL.NEWMAIL_JSP);
	}

	@RequestMapping(method = RequestMethod.POST, params = "submitButton=Submit")
	public ModelAndView submit(
			@ModelAttribute("newMail") @Valid CreateMessageForm newMail) {
		// newMail.setTitle("RE:" + newMail.getTitle());
		// newMail.setBody("<blockquote>" + newMail.getBody() +
		// "</blockquote>");
		messageService.addMessage(newMail.toMessage());
		return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
	}

	@RequestMapping(method = RequestMethod.POST, params = "submitButton=Delete")
	public ModelAndView delete(
			@ModelAttribute("newMail") @Valid CreateMessageForm newMail,
			HttpServletRequest request) {
		Integer id = null;

		if (request.getParameter("id") != null
				&& !request.getParameter("id").isEmpty()) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				id = null;

			}

		}
		if (id == null) {
			return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
		}
		User user = userService.getUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		// user.getAccounts();
		MessageStatuss status = messageStatusService.getMessageStatus(id);

		for (Account account : user.getAccounts()) {
			if (account.getId().equals(status.getAccount().getId())) {
				status.setIsDelet(delete(status.getIsDelet()));
			} else if (account.getId()
					.equals(status.getAcountsSender().getId())) {
				status.setIsDeletSender(delete(status.getIsDeletSender()));
			}
		}

		status.setIsDeleted(true);

		messageStatusService.update(status);

		return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
	}

	@RequestMapping(method = RequestMethod.POST, params = "submitButton=Spam")
	public ModelAndView spam(
			@ModelAttribute("newMail") @Valid CreateMessageForm newMail,
			HttpServletRequest request) {
		Integer id = null;

		if (request.getParameter("id") != null
				&& !request.getParameter("id").isEmpty()) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				id = null;

			}

		}
		if (id == null) {
			return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
		}
		User user = userService.getUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		user.getAccounts();
		MessageStatuss status = messageStatusService.getMessageStatus(id);
		status.setIsSpam(true);

		messageStatusService.update(status);

		return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
	}

	@RequestMapping(method = RequestMethod.POST, params = "submitButton=ToFolder")
	public ModelAndView toFolder(
			@ModelAttribute("newMail") @Valid CreateMessageForm newMail,
			HttpServletRequest request) {
		Integer id = null;

		if (request.getParameter("id") != null
				&& !request.getParameter("id").isEmpty()) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				id = null;

			}

		}
		if (id == null) {
			return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
		}
		// User user = userService.getUser(SecurityContextHolder.getContext()
		// .getAuthentication().getName());
		// user.getAccounts();
		MessageStatuss status = messageStatusService.getMessageStatus(id);

		status.setLabel(newMail.getLabel());
		// status.setIsSpam(true);

		messageStatusService.update(status);

		return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
	}

	@ModelAttribute("accounts")
	public Set<Account> genderList() {

		User user = userService.getUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());

		return user.getAccounts();
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

	@InitBinder
	public void initBinder2(WebDataBinder binder) {
		binder.registerCustomEditor(Label.class, "label", lableEditor);

	}

	private DeletStatus delete(DeletStatus status) {
		switch (status) {
		case NOT:
			return DeletStatus.TRASH;
		case TRASH:
			return DeletStatus.DELET;
		default:
			return DeletStatus.NOT;

		}
	}

	@ModelAttribute("labels")
	public Set<Label> labelList(HttpServletRequest request) {

		Integer id = null;

		if (request.getParameter("id") != null
				&& !request.getParameter("id").isEmpty()) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				id = null;

			}

		}

		Set<Label> list = new HashSet<Label>();

		User user = userService.getUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		for (Account account : user.getAccounts()) {

			if (account.getId().equals(
					messageStatusService.getMessageStatus(id).getAccount()
							.getId())) {
				list.addAll(messageStatusService.getMessageStatus(id)
						.getAccount().getLabel());
			}

			if (account.getId().equals(
					messageStatusService.getMessageStatus(id)
							.getAcountsSender().getId())) {
				list.addAll(messageStatusService.getMessageStatus(id)
						.getAcountsSender().getLabel());
			}

		}

		return list;
	}
}
