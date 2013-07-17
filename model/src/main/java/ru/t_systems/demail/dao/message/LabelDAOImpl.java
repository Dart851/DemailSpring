package ru.t_systems.demail.dao.message;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.dao.user.AbstractDAO;
import ru.t_systems.demail.model.message.Label;

@Repository
@Transactional
public class LabelDAOImpl extends AbstractDAO implements LabelDAO {

	public Label getLabel(int id) {

		return (Label) getCurrentSession().find(Label.class, id);

	}

	public void addLabel(Label label) {
		getCurrentSession().merge(label);

	}

	public void update(Label label) {
		getCurrentSession().merge(label);
		
	}

	

}
