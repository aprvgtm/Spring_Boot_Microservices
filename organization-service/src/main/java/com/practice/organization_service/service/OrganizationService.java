package com.practice.organization_service.service;

import com.practice.organization_service.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationById(Long id);

    OrganizationDto getOrganizationByCode(String organizationCode);


}
