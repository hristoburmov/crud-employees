package eu.burmov.crudemployees.entity;

import java.util.List;

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
	@NotNull(message = "Name is required")
	@Size(min = 2, max = 64, message = "Name must be {min}-{max} characters")
	private String name;
	
	@Column(name = "post_code")
	@Range(min = 1000, max = 9999, message = "Post code must be a 4-digit number")
	private Integer postCode;
	
	@Column(name = "location")
	@NotNull(message = "Location is required")
	@Size(min = 5, max = 128, message = "Location must be {min}-{max} characters")
	private String location;
	
	@OneToMany(mappedBy = "office")
	private List<Employee> employee;
	
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

}
