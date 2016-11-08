package ua.nure.ivannikova.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.ivannikova.dto.RealtyDTO;
import ua.nure.ivannikova.dto.SearchDTO;

@Repository
@Transactional
public class RealtyDAOImpl implements RealtyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see ua.nure.ivannikova.dao.RealtyDAO#searchRealties(ua.nure.ivannikova.dto.SearchDTO)
	 */
	@Override
	public List<RealtyDTO> searchRealties(SearchDTO searchDTO) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createSQLQuery(
						"select r.id, r.address, r.square from realty r, type t where r.type_id=t.id and r.address like '%"
								+ searchDTO.getAddress() + "%' and t.name=? and r.square >= ? and r.square <= ? ")
				.setResultTransformer(Transformers.aliasToBean(RealtyDTO.class));
		query.setParameter(0, searchDTO.getType());
		query.setParameter(1, Double.valueOf(searchDTO.getMinSquare()));
		query.setParameter(2, Double.valueOf(searchDTO.getMaxSquare()));
		@SuppressWarnings("unchecked")
		List<RealtyDTO> list = query.list();
		session.close();
		return list;
	}

}
