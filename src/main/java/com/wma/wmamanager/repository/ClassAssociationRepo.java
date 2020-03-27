package com.wma.wmamanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wma.wmamanager.entity.ClassAssociation;
import com.wma.wmamanager.entity.Class;


@Repository
public interface ClassAssociationRepo extends JpaRepository<ClassAssociation, Long> {

	//@Query("FROM classes_associated c WHERE c.classTaken.class_id IN (:ids)")
	//List<ClassAssociation> getStudentsInClass(@Param("ids")List<Long> ids);
	
	List<ClassAssociation> findAllByClassTaken(Class classTaken);
	
	@Query("FROM ClassAssociation WHERE user_id=?1")
	List<ClassAssociation> findByStudId(Long id);
}
