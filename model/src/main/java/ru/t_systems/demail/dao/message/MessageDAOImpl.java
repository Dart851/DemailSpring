package ru.t_systems.demail.dao.message;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.dao.user.AbstractDAO;
import ru.t_systems.demail.model.message.Message;
import ru.t_systems.demail.model.message.MessageStatuss;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MessageDAOImpl extends AbstractDAO implements MessageDAO {

	public Message getMessage(int id) {

		return (Message) getCurrentSession().find(Message.class, id);

	}

	public void addMessage(Message message) {
		getCurrentSession().merge(message);

	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessageByStatus(List<MessageStatuss> status) {
		Query query = getCurrentSession().createQuery(
				"from Message m join m.status s where s.id in (:list)");
		List<Integer> a = new ArrayList<Integer>();
		for (MessageStatuss s : status) {
			a.add(s.getId());
			
		}
		query.setParameter("list", a);
		return query.getResultList();
	}

}
