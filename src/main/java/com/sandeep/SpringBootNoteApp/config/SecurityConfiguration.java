package com.sandeep.SpringBootNoteApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sandeep.SpringBootNoteApp.filter.JSONWebTokenFilter;
import com.sandeep.SpringBootNoteApp.service.CustomUserDetailsService;

/**
 *
 * @author sandeep
 * @since 25th Oct 2020
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JSONWebTokenFilter jSONWebTokenFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/",
				"/swagger-ui.html",
				"/auth",
				"/v2/api-docs",
				"/configuration/ui",
				"/swagger-resources/**",
				"/configuration/security",
				"/swagger-ui.html",
				"/webjars/**").permitAll()
		.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
		.antMatchers("/note/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
		.anyRequest().authenticated()
		.and().exceptionHandling()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		.and()
//		.formLogin();


		http.addFilterBefore(jSONWebTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
