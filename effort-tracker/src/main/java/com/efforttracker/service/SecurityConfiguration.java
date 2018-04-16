package com.efforttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration  extends GlobalAuthenticationConfigurerAdapter{



	@Autowired
	UserDao userDao;
	
  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
	  //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	  //auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
	  auth.userDetailsService(userDetailsService()).passwordEncoder(NoOpPasswordEncoder.getInstance());
  }

  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = userDao.findByEmail(username);
        if(account != null) {
        return new User(account.getEmail(), account.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(account.getRole()));
        
        } else {
          throw new UsernameNotFoundException("could not find the user '"   + username + "'");
        }
      }
      
    };
  }

	
}
