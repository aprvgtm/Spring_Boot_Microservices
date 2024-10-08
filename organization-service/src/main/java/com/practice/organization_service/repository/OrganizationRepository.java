package com.practice.organization_service.repository;

import com.practice.organization_service.dto.OrganizationDto;
import com.practice.organization_service.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {

    OrganizationEntity findByOrganizationCode(String orgCode);
}
