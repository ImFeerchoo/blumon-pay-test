package com.blumonpay.BlumonPayTest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
//				"SELECT * FROM (SELECT username, password, enabled) as users"
				"SELECT username, password, enabled FROM users where username = ?"
				).authoritiesByUsernameQuery(
				"SELECT * FROM (SELECT username, authorities as authority FROM users) as authorities where username = ?"
				);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/users/**").access("hasRole('ROLE_USER')")
			.antMatchers("/terminals/**").access("hasRole('ROLE_USER')")
			.and().formLogin()
			.loginPage("/login").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/terminals/getAll")
			.failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
			.and()
			.logout()
			.logoutSuccessUrl("/login?logout").logoutUrl("/j_spring_security_check_logout")
			.and()
			.exceptionHandling()
			.accessDeniedPage("/login")
			.and()
			.csrf().disable();
	}
	
	
	
	

}
