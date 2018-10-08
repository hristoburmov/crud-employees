package eu.burmov.crudemployees.dao;

import java.util.List;

import eu.burmov.crudemployees.entity.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void saveEmployee(Employee e);
	public void deleteEmployee(int id);
}
