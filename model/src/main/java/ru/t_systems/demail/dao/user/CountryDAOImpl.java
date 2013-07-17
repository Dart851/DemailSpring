package ru.t_systems.demail.dao.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.model.user.Country;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CountryDAOImpl extends AbstractDAO implements CountryDAO {

	@Transactional(readOnly = true)
	public Country getCountry(int id) {

		return (Country) getCurrentSession().find(Country.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Country> getAllCountry() {

		return getCurrentSession().createQuery("from Country").getResultList();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Country getCountry(String name) {
		List<Country> userList = new ArrayList<Country>();

		Query query = getCurrentSession().createQuery(
				"from Country u where u.id = :name");
		query.setParameter("name", Integer.valueOf(name));
		userList = query.getResultList();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

}
