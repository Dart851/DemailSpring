package ru.t_systems.demail.dao.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.model.user.User;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl extends AbstractDAO implements UserDAO {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = getCurrentSession().createQuery(
				"from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.getResultList();

		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	public void addUser(User user) {
		getCurrentSession().persist(user);

	}

	public void update(User user) {
		getCurrentSession().merge(user);

	}

	public void deleteUser(User user) {
		getCurrentSession().remove(user);

	}

}
