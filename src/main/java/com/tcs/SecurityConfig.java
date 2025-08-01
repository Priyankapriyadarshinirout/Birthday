package com.tcs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/birthday").hasRole("USER")
				.anyRequest().permitAll())
				.formLogin(form -> form.loginPage("/login").permitAll())
				.logout().permitAll();
		return http.build();
	}
	 @Bean
	    public UserDetailsService users(DataSource dataSource) {
	        return new JdbcUserDetailsManager(dataSource);
	    }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	     return NoOpPasswordEncoder.getInstance(); // Use only for testing
	 }

}
