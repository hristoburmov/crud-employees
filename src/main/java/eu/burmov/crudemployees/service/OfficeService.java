package eu.burmov.crudemployees.service;

import java.util.List;

import eu.burmov.crudemployees.entity.Office;

public interface OfficeService {
	public List<Office> getOffices();
	public Office getOffice(int id);
	public void saveOffice(Office o);
	public void deleteOffice(int id);
}
