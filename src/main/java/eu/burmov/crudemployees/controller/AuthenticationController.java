package eu.burmov.crudemployees.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.burmov.crudemployees.user.UserDetails;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
	
	private UserDetailsManager userManager;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	// Constructors
	@Autowired
	public AuthenticationController(UserDetailsManager userManager) {
		this.userManager = userManager;
	}
	
	@RequestMapping("/denied")
	public String denied() {
		return "authentication/denied";
	}

	// Login
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String loginForm() {
		return "authentication/login";
	}
	
	// Register
	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new UserDetails());
		return "authentication/register";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String registerProcess(@Valid @ModelAttribute("user") UserDetails u, BindingResult result, Model model) {
		
		// Validation errors
		if(result.hasErrors()) {
			return "authentication/register";
		}
		
		// Username exists
		if(userManager.userExists(u.getUsername())) {
			result.addError(new ObjectError("username", "Username already exists"));
			return "authentication/register";
		}
		
		// Create user details and save user
		String username = u.getUsername();
		String password = "{bcrypt}" + passwordEncoder.encode(u.getPassword());
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_MANAGER");
		userManager.createUser(new User(username, password, authorities));
		
		return "authentication/success";
	}

}
