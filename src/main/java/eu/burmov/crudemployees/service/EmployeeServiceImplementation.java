package eu.burmov.crudemployees.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.burmov.crudemployees.dao.EmployeeDao;
import eu.burmov.crudemployees.entity.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee e) {
		employeeDao.saveEmployee(e);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

}
