package ru.t_systems.demail.dao.message;

import ru.t_systems.demail.model.message.Message;
import ru.t_systems.demail.model.message.MessageStatuss;

import java.util.List;

public interface MessageDAO {

    public Message getMessage(int id);

    public void addMessage(Message message);

    public List<Message> getMessageByStatus(List<MessageStatuss> status);

}
