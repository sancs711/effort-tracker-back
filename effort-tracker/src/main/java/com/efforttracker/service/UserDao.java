package com.efforttracker.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends JpaRepository<UserAccount, Long> {
	
	public UserAccount findByEmail(String email);

}
