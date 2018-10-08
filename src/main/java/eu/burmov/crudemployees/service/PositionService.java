package eu.burmov.crudemployees.service;

import java.util.List;

import eu.burmov.crudemployees.entity.Position;

public interface PositionService {
	public List<Position> getPositions();
	public Position getPosition(int id);
	public void savePosition(Position p);
	public void deletePosition(int id);
}
