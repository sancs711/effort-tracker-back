/**
 * 
 */
package com.efforttracker.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jatin.singh
 *
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .authoritiesByUsernameQuery("select email,password, isactive from users where email=?")
            .usersByUsernameQuery("select email, role from user_roles where email=?");
    }*/
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
      .antMatchers("/").permitAll().antMatchers("/user").permitAll()
      .anyRequest().fullyAuthenticated().and()
      .httpBasic().and().
      csrf().disable();
    }
    

}


