package eu.burmov.crudemployees.dao;

import java.util.List;

import eu.burmov.crudemployees.entity.Position;

public interface PositionDao {
	public List<Position> getPositions();
	public Position getPosition(int id);
	public void savePosition(Position p);
	public void deletePosition(int id);
}
