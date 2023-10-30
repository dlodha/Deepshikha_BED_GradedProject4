package com.glearning.employeeManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.glearning.employeeManagement.serviceImpl.DomainUserDetailService;



@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//used to configure both authentication and authorization
	@Autowired
	private DomainUserDetailService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(this.userDetailsService)
			.passwordEncoder(this.passwordEncoder);
		
	}
	
	
	//authorization
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		
		
		//define the rules which will tell who can access what url's
		httpSecurity
					.authorizeRequests()
					.antMatchers("/login","/api/role/create","/api/user/create")
						.permitAll()
					.antMatchers("/api/employees/list","/api/employees/view/**",
							"/api/employees/delete/**","/api/employees/search/**",
							"/api/employees/sort/**","/api/employees/edit/**")
						.hasAnyAuthority("USER", "ADMIN")
					.antMatchers("/api/employees/create")
						.hasAuthority("ADMIN")
					.anyRequest()
						.authenticated()
					.and()
						.formLogin()
					.and()
						.httpBasic()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
						
					
	}

}
