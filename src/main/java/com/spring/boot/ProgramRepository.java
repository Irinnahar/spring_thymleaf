package com.spring.boot;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgramRepository extends JpaRepository<Program, Long>{
	
	/*
	 * @Query("SELECT u FROM Program u WHERE u.email = ?1") public User
	 * findByEmail(String email);
	 */
}
