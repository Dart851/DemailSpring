package ru.t_systems.demail.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.t_systems.demail.dao.message.LabelDAO;
import ru.t_systems.demail.model.message.Label;

@Service
@Transactional
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDAO labelDAO;

    public Label getLabel(int id) {
        return labelDAO.getLabel(id);
    }

    public void addLabel(Label label) {
    	labelDAO.addLabel(label);

    }

	public void update(Label label) {
		labelDAO.update(label);
		
	}

	   

}
