package eu.burmov.crudemployees.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private DataSource dataSource;
	
	// Constructors
	@Autowired
	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/employees/**").hasRole("MANAGER")
			.antMatchers("/positions/**").hasRole("MANAGER")
			.antMatchers("/offices/**").hasRole("MANAGER")
				.and()
			.formLogin()
			.loginPage("/auth/login")
			.loginProcessingUrl("/auth/login")
			.permitAll()
				.and()
			.logout()
			.permitAll()
				.and()
			.exceptionHandling().accessDeniedPage("/auth/denied");
	}

}
