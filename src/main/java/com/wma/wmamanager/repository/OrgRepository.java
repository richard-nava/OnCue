package com.wma.wmamanager.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wma.wmamanager.entity.Organization;

@Repository
public interface OrgRepository extends JpaRepository<Organization, Long> {

	Optional<Organization> getByOrgName(String orgName);
	
	@Query("FROM Organization WHERE user_id=?1")
	List<Organization> getByUser(Long id);
	

}
