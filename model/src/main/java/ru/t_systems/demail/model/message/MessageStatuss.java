package ru.t_systems.demail.model.message;

import ru.t_systems.demail.model.user.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "status")
public class MessageStatuss implements Comparable<MessageStatuss> {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    // (cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_sender_id")
    private Account acountsSender;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Message message;
    @ManyToOne
    // (cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Label label;
    private Date timeStamp = new Date();
    @Enumerated(EnumType.ORDINAL)
    private DeletStatus isDelet = DeletStatus.NOT;
    @Enumerated(EnumType.ORDINAL)
    private DeletStatus isDeletSender = DeletStatus.NOT;
    private Boolean isRead = false;
    private Boolean isDeleted = false;
    private Boolean isSpam = false;

    public MessageStatuss() {
        this.isRead = false;
        this.isDeleted = false;
    }

    public DeletStatus getIsDeletSender() {
        return isDeletSender;
    }

    public void setIsDeletSender(DeletStatus isDeletSender) {
        this.isDeletSender = isDeletSender;
    }

    public DeletStatus getIsDelet() {
        return isDelet;
    }

    public void setIsDelet(DeletStatus isDelet) {
        this.isDelet = isDelet;
    }

    public int compareTo(MessageStatuss status) {

        if (this.getTimeStamp().compareTo(status.getTimeStamp()) == -1
                && !this.getId().equals(status.getId())) {
            return -1;
        } else if (this.getTimeStamp().compareTo(status.getTimeStamp()) == 1
                && !this.getId().equals(status.getId())) {
            return 1;
        } else {
            return this.getId().compareTo(status.getId());
        }

    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Boolean getIsSpam() {
        return isSpam;
    }

    public void setIsSpam(Boolean isSpam) {
        this.isSpam = isSpam;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Account getAcountsSender() {
        return acountsSender;
    }

    public void setAcountsSender(Account acountsSender) {
        this.acountsSender = acountsSender;
    }

    public Account getAcounts() {
        return account;
    }

    public void setAcounts(Account acounts) {
        this.account = acounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
