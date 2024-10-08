package com.practice.organization_service.controller;

import com.practice.organization_service.dto.OrganizationDto;
import com.practice.organization_service.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "This is the Organization service controller"
)
@AllArgsConstructor
@RestController
@RequestMapping("/app/org")
public class OrganizationController {

    private OrganizationService organizationService;

    // Custom Swagger Api documentation.................
    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization data into data base"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status code 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
       OrganizationDto savedOrg= organizationService.saveOrganization(organizationDto);
       return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization data from data base by id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status code 200 OK"
    )
    @GetMapping("id/{id}")
    public ResponseEntity<OrganizationDto> getById(@PathVariable Long id){
      OrganizationDto getOrgById =  organizationService.getOrganizationById(id);
      return new ResponseEntity<>(getOrgById, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization data from data base by code."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status code 200 OK"
    )
    @GetMapping("{orgCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String orgCode){
      OrganizationDto organizationDto =  organizationService.getOrganizationByCode(orgCode);
      return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
