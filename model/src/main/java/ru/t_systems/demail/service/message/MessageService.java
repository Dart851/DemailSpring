package ru.t_systems.demail.service.message;

import ru.t_systems.demail.model.message.Message;
import ru.t_systems.demail.model.message.MessageStatuss;

import java.util.List;

public interface MessageService {

    public Message getMessage(int id);

    public void addMessage(Message message);

    public List<Message> getMessageByStatus(List<MessageStatuss> status);

    public List<Message> getMessageByStatus(MessageStatuss status);
}
