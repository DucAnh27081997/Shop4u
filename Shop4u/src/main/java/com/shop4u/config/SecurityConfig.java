package com.shop4u.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource) // set data source

				.usersByUsernameQuery("select username, password, enable from users where username =?")// lay
																													// mk
				.authoritiesByUsernameQuery("select username, role from users where username = ?"); // vai tro nguoi
																									// dung
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin/**")
			.hasRole("ADMIN")
			
		.and()
			.authorizeRequests()
			.antMatchers("/admin/**")
			.hasRole("SA")
			.anyRequest().permitAll()	
		.and()
			.authorizeRequests()
			.antMatchers("/user/**")
			.hasRole("USER")
			.anyRequest().permitAll()
		.and()
		.formLogin()
			.loginPage("/dang-nhap")
			.loginProcessingUrl("/login")
			.usernameParameter("username")
			.passwordParameter("password")
		.defaultSuccessUrl("/admin/danh-sach-san-pham")
		.failureUrl("/dang-nhap?error=failed")
		.and().exceptionHandling().accessDeniedPage("/dang-nhap?error=deny");
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/template/**","/DATA/**");
	}

}
