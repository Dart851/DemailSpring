package ru.t_systems.demail.controllers.models;

import ru.t_systems.demail.model.message.Label;
import ru.t_systems.demail.model.message.Message;
import ru.t_systems.demail.model.message.MessageStatuss;
import ru.t_systems.demail.model.user.Account;

import java.util.*;

public class CreateMessageForm {
    private String title = new String();
    private String body = new String();
    private String bodyFast = new String();
    private Set<Account> accounts;
    private Account accountSender;
    private Date date = new Date();
    private Label label;
   
    public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public CreateMessageForm() {
    }

    public CreateMessageForm(MessageStatuss status) {
        this.title = status.getMessage().getTitle();
        this.body = status.getMessage().getBody();
        this.accountSender = status.getAccount();
        // System.out.println("-------Mesage account count"
        // + status.getMessage().getStatus().size());
        Set<Account> accounts = new HashSet<Account>();
        accounts.add(status.getAcountsSender());
        this.label=status.getLabel()!=null?status.getLabel():null;
        this.setAccounts(accounts);
    }

    public Message toMessage() {

        Message message = new Message();
        List<MessageStatuss> statusSet = new ArrayList<MessageStatuss>();

        message.setBody(this.getBodyFast() + this.getBody());
        message.setTitle(this.getTitle());

        for (Account ac : accounts) {
            MessageStatuss statuss = new MessageStatuss();
            statuss.setAccount(ac);
            statuss.setAcountsSender(this.getAccountSender());
            statusSet.add(statuss);
        }

        message.setStatus(statusSet);
        return message;
    }

    public String getBodyFast() {
        return bodyFast;
    }

    public void setBodyFast(String bodyFast) {
        this.bodyFast = bodyFast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}