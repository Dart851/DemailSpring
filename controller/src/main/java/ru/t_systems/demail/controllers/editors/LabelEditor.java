package ru.t_systems.demail.controllers.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.t_systems.demail.service.message.LabelService;

@Component
public class LabelEditor extends PropertyEditorSupport {

	@Autowired
	private LabelService labelService;

	@Override
	public void setAsText(final String text) {

		System.out.println("---------------LABEL EDITOR");
		if (!text.equals("NONE") && !text.isEmpty()) {
			setValue(labelService.getLabel(Integer.valueOf(text)));
		}
	}

}
