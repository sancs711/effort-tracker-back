/**
 * 
 */
package com.efforttracker.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jatin.singh
 *
 */
public class SecurityService extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("datasource")
	DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .authoritiesByUsernameQuery(usersQuery)
            .usersByUsernameQuery(rolesQuery);
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()                      // it indicate basic authentication is requires
                .and()
                .authorizeRequests()
                //.antMatchers("/login").permitAll() // /login will be accessible directly, no need of any authentication
                .anyRequest().authenticated();    // it's indicate all request will be secure
        
    }
    

}


