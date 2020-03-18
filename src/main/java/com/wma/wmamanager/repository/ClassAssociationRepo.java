package com.wma.wmamanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wma.wmamanager.entity.ClassAssociation;

@Repository
public interface ClassAssociationRepo extends JpaRepository<ClassAssociation, Long> {

	
}
