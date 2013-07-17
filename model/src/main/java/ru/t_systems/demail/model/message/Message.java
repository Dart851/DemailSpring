package ru.t_systems.demail.model.message;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "BODY", columnDefinition = "TEXT")
    private String body;
    private Date timeStamp = new Date();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinTable(name = "status_message", joinColumns = { @JoinColumn(name =
    // "message_id", referencedColumnName = "id") }, inverseJoinColumns = {
    // @JoinColumn(name = "status_id", referencedColumnName = "id") })
    @JoinColumn(name = "message_id")
    private List<MessageStatuss> status;
    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<MessageStatuss> getStatus() {
        return status;
    }

    public void setStatus(List<MessageStatuss> status) {
        this.status = status;
    }

}