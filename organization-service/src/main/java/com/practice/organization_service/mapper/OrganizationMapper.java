package com.practice.organization_service.mapper;

import com.practice.organization_service.dto.OrganizationDto;
import com.practice.organization_service.entity.OrganizationEntity;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationEntityToDto(OrganizationEntity organizationEntity){
        OrganizationDto organizationDto= new OrganizationDto();
        organizationDto.setId(organizationEntity.getId());
        organizationDto.setOrganizationName(organizationEntity.getOrganizationName());
        organizationDto.setOrganizationDescription(organizationEntity.getOrganizationDescription());
        organizationDto.setOrganizationCode(organizationEntity.getOrganizationCode());
        organizationDto.setCreatedDate(organizationEntity.getCreatedDate());
        return organizationDto;
    }

    public static OrganizationEntity mapTDtoToOrganizationEntity(OrganizationDto organizationDto){
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setId(organizationDto.getId());
        organizationEntity.setOrganizationName(organizationDto.getOrganizationName());
        organizationEntity.setOrganizationDescription(organizationDto.getOrganizationDescription());
        organizationEntity.setOrganizationCode(organizationDto.getOrganizationCode());
        organizationEntity.setCreatedDate(organizationDto.getCreatedDate());
        return organizationEntity;
    }
}
