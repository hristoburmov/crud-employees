package eu.burmov.crudemployees.service;

import java.util.List;

import eu.burmov.crudemployees.entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void saveEmployee(Employee e);
	public void deleteEmployee(int id);
}
