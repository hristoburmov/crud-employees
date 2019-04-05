package eu.burmov.crudemployees.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.burmov.crudemployees.entity.Office;

@Repository
public class OfficeDaoImplementation implements OfficeDao {
	
	private SessionFactory factory;
	
	// Constructors
	@Autowired
	public OfficeDaoImplementation(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Office> getOffices() {
		Session session = factory.getCurrentSession();
		return (session.createQuery("FROM Office", Office.class)).getResultList();
	}

	@Override
	public Office getOffice(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Office.class, id);
	}

	@Override
	public void saveOffice(Office o) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(o);
	}

	@Override
	public void deleteOffice(int id) {
		Session session = factory.getCurrentSession();
		Office office = session.get(Office.class, id);
		if(office != null) {
			session.delete(office);
		}
	}

}
