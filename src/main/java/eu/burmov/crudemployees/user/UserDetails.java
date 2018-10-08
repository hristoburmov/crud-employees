package eu.burmov.crudemployees.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetails {
	
	@NotNull(message = "Username is required")
	@Size(min = 3, max = 20, message = "Username must be {min}-{max} characters")
	private String username;
	
	@NotNull(message = "Password is required")
	@Size(min = 8, message = "Password must be at least {min} characters")
	private String password;
	
	// Constructors
	public UserDetails() {}
	public UserDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// Getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
