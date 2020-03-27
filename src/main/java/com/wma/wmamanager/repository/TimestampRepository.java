package com.wma.wmamanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wma.wmamanager.entity.SignInTime;

@Repository
public interface TimestampRepository extends JpaRepository<SignInTime, Long> {
	
	@Query("FROM SignInTime WHERE pin=?1")
	List<SignInTime> getSignInTimes(int pin);
}
