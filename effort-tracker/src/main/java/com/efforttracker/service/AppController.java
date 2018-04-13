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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jatin.singh
 *
 */
@RestController
public class AppController {
	
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping("/login")
	public String hello(@RequestParam String name) {
		return "Hello "+name;
	}
	
	
	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<List<User>> findAll() {
	    final List<User> resultList = new ArrayList<>();
	    final Iterable<User> all = userDao.findAll();
	    all.forEach(resultList::add);
	    return ResponseEntity.ok().body(resultList);
	  }
	

}
