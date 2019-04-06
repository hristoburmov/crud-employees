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
	@NotNull(message = "{firstName.null}")
	@Size(min = 2, max = 64, message = "{firstName.size}")
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull(message = "{lastName.null}")
	@Size(min = 2, max = 64, message = "{lastName.size}")
	private String lastName;
	
	@Column(name = "email")
	@Email(message = "{email.invalid}")
	@NotNull(message = "{email.null}")
	@Size(min = 10, max = 128, message = "{email.size}")
	private String email;
	
	@Column(name = "salary")
	@NotNull(message = "{salary.null}")
	@Range(min = 1, max = 9999, message = "{salary.range}")
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
