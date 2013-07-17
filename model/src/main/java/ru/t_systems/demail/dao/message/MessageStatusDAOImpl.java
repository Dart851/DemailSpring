package ru.t_systems.demail.dao.message;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.dao.user.AbstractDAO;
import ru.t_systems.demail.model.message.DeletStatus;
import ru.t_systems.demail.model.message.MessageStatuss;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class MessageStatusDAOImpl extends AbstractDAO implements
		MessageStatusDAO {

	@Transactional(readOnly = true)
	public MessageStatuss getMessageStatus(int id) {

		return (MessageStatuss) getCurrentSession().find(MessageStatuss.class,
				id);

	}

	public void addStatusUser(MessageStatuss messageStatus) {
		getCurrentSession().persist(messageStatus);

	}

	public void addStatusUser(Set<MessageStatuss> messageStatus) {
		for (MessageStatuss status : messageStatus) {
			getCurrentSession().persist(status);
		}

	}

	@SuppressWarnings("unchecked")
	@Deprecated
	public List<MessageStatuss> getMessageStatussByAccount1(
			List<Integer> accounts) {

		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.account in (:id) and s.isDelet = :delete and s.isSpam = :spam");
		query.setParameter("id", accounts);
		query.setParameter("delete", DeletStatus.NOT);
		query.setParameter("spam", false);
		return query.getResultList();
	}

	@Transactional
	public void update(MessageStatuss messageStatus) {
		System.out.println("---UPDATE START");

		getCurrentSession().merge(messageStatus);
		System.out.println("---UPDATE FINISH");

	}

	@SuppressWarnings("unchecked")
	public List<MessageStatuss> getInputStatus(int accountId, int limit,
			int offset) {
		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.account.id = :id and s.isDelet = :delete and s.isSpam = :spam");
		query.setParameter("id", accountId);
		query.setParameter("delete", DeletStatus.NOT);
		query.setParameter("spam", false);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		return query.getResultList();
		// return null;
	}

	@SuppressWarnings("unchecked")
	public List<MessageStatuss> getOutputStatus(int accountId, int limit,
			int offset) {
		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.acountsSender.id = :id and s.isDeletSender = :delete");
		query.setParameter("id", accountId);
		// query.setParameter("delete", DeletStatus.NOT);
		// query.setParameter("spam", false);
		query.setParameter("delete", DeletStatus.NOT);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<MessageStatuss> getSpamStatus(int accountId, int limit,
			int offset) {
		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.account.id = :id and s.isDelet = :delete and s.isSpam = :spam");
		query.setParameter("id", accountId);
		query.setParameter("delete", DeletStatus.NOT);
		query.setParameter("spam", true);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<MessageStatuss> getTrashStatus(int accountId, int limit,
			int offset) {
		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.account.id = :id and s.isDelet = :delete and s.isSpam = :spam");
		query.setParameter("id", accountId);
		query.setParameter("delete", DeletStatus.TRASH);
		query.setParameter("spam", false);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		return query.getResultList();
	}

	public Integer getInputStatusCount(List<Integer> accountsId) {
		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.account.id = :id and s.isDelet = :delete and s.isSpam = :spam");
		query.setParameter("id", 1);
		query.setParameter("delete", DeletStatus.NOT);
		query.setParameter("spam", false);

		return query.getResultList().size();
		// return null;
	}

	public List<MessageStatuss> getInputStatusFromLabel(int accountId,
			int labelId, int limit, int offset) {
		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.account.id = :id and s.isDelet = :delete and s.isSpam = :spam and s.label.id = :label");
		query.setParameter("id", accountId);
		query.setParameter("delete", DeletStatus.NOT);
		query.setParameter("spam", false);
		query.setParameter("label", labelId);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		return query.getResultList();

	}

	public Integer getOutputStatusCount(List<Integer> accountsId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getSpamStatusCount(List<Integer> accountsId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getTrashCount(List<Integer> accountsId) {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageStatuss getMessageStatus(int statusId, int userId) {

		Query query = getCurrentSession()
				.createQuery(
						"from MessageStatuss s where s.id = :statusId and s.account.id = :userId or s.acountsSender.id = :userSenderId");
		query.setParameter("statusId", statusId);

		query.setParameter("userId", userId);

		if (query.getResultList().size() > 0) {
			return (MessageStatuss) query.getResultList().get(0);
		} else {
			return null;
		}
	}

}
