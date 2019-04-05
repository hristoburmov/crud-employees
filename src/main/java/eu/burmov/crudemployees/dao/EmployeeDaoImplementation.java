package eu.burmov.crudemployees.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.burmov.crudemployees.entity.Employee;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {
	
	private SessionFactory factory;
	
	// Constructors
	@Autowired
	public EmployeeDaoImplementation(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Employee> getEmployees() {
		Session session = factory.getCurrentSession();
		return (session.createQuery("from Employee", Employee.class)).getResultList();
	}
	
	@Override
	public Employee getEmployee(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Employee.class, id);
	}

	@Override
	public void saveEmployee(Employee e) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(e);
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = factory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		if(employee != null) {
			session.delete(employee);
		}
	}

}
