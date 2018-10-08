package eu.burmov.crudemployees.dao;

import java.util.List;

import eu.burmov.crudemployees.entity.Office;

public interface OfficeDao {
	public List<Office> getOffices();
	public Office getOffice(int id);
	public void saveOffice(Office o);
	public void deleteOffice(int id);
}
