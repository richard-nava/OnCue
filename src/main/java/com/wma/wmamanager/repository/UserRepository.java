package com.wma.wmamanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wma.wmamanager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> getByEmail(String email);
	
	@Query("FROM User WHERE email=?1 AND password=?2")
	Optional<User> login(String email, String password);

	@Query("FROM User WHERE firstName=?1 OR lastName=?1 OR email=?1")
	List<User> searchByName(String name);
	
	@Query("FROM User WHERE pin=?1")
	Optional<User> pinSignIn(int pin);
	
	@Query("FROM User WHERE role=Student")
	List<User> getStudents();
	
	
}
