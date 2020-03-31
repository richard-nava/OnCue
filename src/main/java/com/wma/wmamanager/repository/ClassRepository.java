package com.wma.wmamanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wma.wmamanager.entity.Class;
import com.wma.wmamanager.entity.Organization;
import com.wma.wmamanager.entity.User;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

	@Query("FROM Class WHERE class_name=?1 AND org_id=?2")
	Optional<Class> getByName(String name, Long id);
	
	@Query("FROM Class WHERE class_id=?1")
	Optional<List<User>> viewStudents(Long id);
	
	@Query("FROM Class WHERE org_id=?1")
	List<Class> getByOrg(Long id);
	
	//@Query("DELETE FROM Class WHERE class_id=?1")
	//int deleteAllByClassId(long id);
	
}
