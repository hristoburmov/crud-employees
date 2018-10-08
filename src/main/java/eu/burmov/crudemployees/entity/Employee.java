package eu.burmov.crudemployees.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	@NotNull(message = "First name is required")
	@Size(min = 2, max = 64, message = "First name must be {min}-{max} characters")
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull(message = "Last name is required")
	@Size(min = 2, max = 64, message = "Last name must be {min}-{max} charactes")
	private String lastName;
	
	@Column(name = "email")
	@Email(message = "Email is invalid")
	@NotNull(message = "Email is required")
	@Size(min = 10, max = 128, message = "Email must be {min}-{max} characters")
	private String email;
	
	@Column(name = "salary")
	@NotNull(message = "Salary is required")
	@Range(min = 1, max = 9999, message = "Salary must be between {min}-{max}")
	private Integer salary;
	
	@ManyToOne
	@JoinColumn(name = "position")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "office")
	private Office office;
	
	// Constructors
	public Employee() {}
	public Employee(String firstName, String lastName, String email, Integer salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}
	
	// Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}

}
