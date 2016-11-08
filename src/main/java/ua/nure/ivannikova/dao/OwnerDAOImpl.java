package ua.nure.ivannikova.dao;

import static ua.nure.ivannikova.security.Password.hash;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.ivannikova.entity.Owner;

@Repository
@Transactional
public class OwnerDAOImpl implements OwnerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see ua.nure.ivannikova.dao.OwnerDAO#getOwnerByCredentials(java.lang.String, java.lang.String)
	 */
	@Override
	public Owner getOwnerByCredentials(String login, String password) {
		Session session = sessionFactory.openSession();
		password = hash(password);
		Query query = session
				.createSQLQuery("select * from owner o where (o.login = ? or o.email = ?) and o.password = ?")
				.addEntity("o", Owner.class);
		query.setParameter(0, login);
		query.setParameter(1, login);
		query.setParameter(2, password);

		@SuppressWarnings("unchecked")
		List<Owner> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}
