package eu.burmov.crudemployees.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.burmov.crudemployees.entity.Position;

@Repository
public class PositionDaoImplementation implements PositionDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Position> getPositions() {
		Session session = factory.getCurrentSession();
		return (session.createQuery("FROM Position", Position.class)).getResultList();
	}

	@Override
	public Position getPosition(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Position.class, id);
	}

	@Override
	public void savePosition(Position p) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
	}

	@Override
	public void deletePosition(int id) {
		Session session = factory.getCurrentSession();
		Position position = session.get(Position.class, id);
		if(position != null) {
			session.delete(position);
		}
	}

}
