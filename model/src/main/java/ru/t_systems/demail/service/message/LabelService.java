package ru.t_systems.demail.service.message;

import ru.t_systems.demail.model.message.Label;

public interface LabelService {

	public Label getLabel(int id);

    public void addLabel(Label label);

    public void update(Label label);
}
