package ru.t_systems.demail.dao.message;

import ru.t_systems.demail.model.message.Label;

public interface LabelDAO {

    public Label getLabel(int id);

    public void addLabel(Label label);

    public void update(Label label);
    //public List<Message> getMessageByStatus(List<MessageStatuss> status);

}
