package com.wma.wmamanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wma.wmamanager.entity.Organization;

@Repository
public interface OrgRepository extends JpaRepository<Organization, Long> {

	Optional<Organization> getByOrgName(String orgName);

}
