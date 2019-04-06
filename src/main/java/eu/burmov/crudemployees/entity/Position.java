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

@Entity
@Table(name = "positions")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	@NotNull(message = "{title.null}")
	@Size(min = 3, max = 64, message = "{title.size}")
	private String title;
	
	@OneToMany(mappedBy = "position")
	private List<Employee> employee;
	
	// Constructors
	public Position() {}
	public Position(String title) {
		this.title = title;
	}
	
	// Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
