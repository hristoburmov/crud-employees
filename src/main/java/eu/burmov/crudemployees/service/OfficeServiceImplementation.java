package eu.burmov.crudemployees.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.burmov.crudemployees.dao.OfficeDao;
import eu.burmov.crudemployees.entity.Office;

@Service
public class OfficeServiceImplementation implements OfficeService {

	private OfficeDao officeDao;

	// Constructors
	@Autowired
	public OfficeServiceImplementation(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	@Override
	@Transactional
	public List<Office> getOffices() {
		return officeDao.getOffices();
	}

	@Override
	@Transactional
	public Office getOffice(int id) {
		return officeDao.getOffice(id);
	}

	@Override
	@Transactional
	public void saveOffice(Office o) {
		officeDao.saveOffice(o);
	}

	@Override
	@Transactional
	public void deleteOffice(int id) {
		officeDao.deleteOffice(id);
	}

}
