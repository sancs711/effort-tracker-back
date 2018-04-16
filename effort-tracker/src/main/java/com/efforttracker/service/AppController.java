/**
 * 
 */
package com.efforttracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jatin.singh
 *
 */
@RestController
public class AppController {
	
	@Autowired
	UserDao userDao;
	
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserAccount login(@RequestBody UserAccount user) {
		user = userDao.findByEmail(user.getEmail());
		return user;
	}
	
	
	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<List<UserAccount>> findAll() {
		System.out.println("This is coming here in the mehod as well");
	    final List<UserAccount> resultList = new ArrayList<>();
	    final Iterable<UserAccount> all = userDao.findAll();
	    all.forEach(resultList::add);
	    return ResponseEntity.ok().body(resultList);
	  }
	

}
