package com.practice.organization_service.service.impl;

import com.practice.organization_service.dto.OrganizationDto;
import com.practice.organization_service.entity.OrganizationEntity;
import com.practice.organization_service.exception.OrganizationNotFoundException;
import com.practice.organization_service.mapper.OrganizationMapper;
import com.practice.organization_service.repository.OrganizationRepository;
import com.practice.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        OrganizationEntity organizationEntity = OrganizationMapper.mapTDtoToOrganizationEntity(organizationDto);
        OrganizationEntity savedOrganization =   organizationRepository.save(organizationEntity);

        OrganizationDto responseDto = OrganizationMapper.mapToOrganizationEntityToDto(savedOrganization);

        return responseDto;
    }

    @Override
    public OrganizationDto getOrganizationById(Long id) {
      OrganizationEntity organizationEntity = organizationRepository.findById(id).
              orElseThrow(() -> new OrganizationNotFoundException("Organization not available" + id));
      OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationEntityToDto(organizationEntity);
        return organizationDto;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
       OrganizationEntity organizationEntity = organizationRepository.findByOrganizationCode(organizationCode);
       OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationEntityToDto(organizationEntity);
        return organizationDto;
    }
}
