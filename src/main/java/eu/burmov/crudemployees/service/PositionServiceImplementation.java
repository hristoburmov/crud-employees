package eu.burmov.crudemployees.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.burmov.crudemployees.dao.PositionDao;
import eu.burmov.crudemployees.entity.Position;

@Service
public class PositionServiceImplementation implements PositionService {
	
	private PositionDao positionDao;

	// Constructors
	@Autowired
	public PositionServiceImplementation(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	@Transactional
	public List<Position> getPositions() {
		return positionDao.getPositions();
	}

	@Override
	@Transactional
	public Position getPosition(int id) {
		return positionDao.getPosition(id);
	}

	@Override
	@Transactional
	public void savePosition(Position p) {
		positionDao.savePosition(p);
	}

	@Override
	@Transactional
	public void deletePosition(int id) {
		positionDao.deletePosition(id);
	}

}
