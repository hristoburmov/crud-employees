package eu.burmov.crudemployees.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "offices")
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	@NotNull(message = "{name.null}")
	@Size(min = 2, max = 64, message = "{name.size}")
	private String name;
	
	@Column(name = "post_code")
	@Range(min = 1000, max = 9999, message = "{postCode.range}")
	private Integer postCode;
	
	@Column(name = "location")
	@NotNull(message = "{location.null}")
	@Size(min = 5, max = 128, message = "{location.size}")
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
	private List<Employee> employees;
	
	// Constructors
	public Office() {}
	public Office(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	// Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPostCode() {
		return postCode;
	}
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
