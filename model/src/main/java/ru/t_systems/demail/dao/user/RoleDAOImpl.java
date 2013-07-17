package ru.t_systems.demail.dao.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.model.user.Role;

@Repository
@Transactional
public class RoleDAOImpl extends AbstractDAO implements RoleDAO {

	@Transactional(readOnly = true)
	public Role getRole(int id) {

		return (Role) getCurrentSession().find(Role.class, id);
	}

	public void saveRole(Role role) {
		getCurrentSession().persist(role);

	}

}
