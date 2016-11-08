package ua.nure.ivannikova.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.ivannikova.dto.ViewingDTO;
import ua.nure.ivannikova.entity.Owner;
import ua.nure.ivannikova.entity.Realty;
import ua.nure.ivannikova.entity.Viewing;

@Repository
@Transactional
public class ViewingDAOImpl implements ViewingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ViewingDTO> getViewingsByDateAndOwnerId(Date date, Owner owner) {

		Session session = sessionFactory.openSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Query query = session
				.createSQLQuery(
						"select v.datetime, r.address, v.firstname, v.lastname, v.phone from viewing v, realty r where v.realty_id=r.id and v.realty_id in (select id from realty where owner_id=?) and date_trunc('day', v.datetime) = '"
								+ df.format(date) + " 00:00:00+02'")
				.setResultTransformer(Transformers.aliasToBean(ViewingDTO.class));
		query.setParameter(0, owner.getId());
		@SuppressWarnings("unchecked")
		List<ViewingDTO> list = query.list();
		session.close();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.nure.ivannikova.dao.ViewingDAO#createViewing(ua.nure.ivannikova.dto.
	 * ViewingDTO, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean createViewing(ViewingDTO viewingDTO, String date, String time) {

		Session session = sessionFactory.openSession();
		String sourcedate = "" + date + " " + time + ":00";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = null;
		try {
			d = df.parse(sourcedate);
		} catch (ParseException e) {
			return false;
		}

		Viewing viewing = new Viewing();
		Long id = viewingDTO.getId();
		Realty realty = session.load(Realty.class, id);
		viewing.setRealty(realty);
		viewing.setDatetime(d);
		viewing.setFirstname(viewingDTO.getFirstname());
		viewing.setLastname(viewingDTO.getLastname());
		viewing.setPhone(viewingDTO.getPhone());

		try {
			session.save(viewing);
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

}
