package net.practice.employeeservice.client;

import net.practice.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationClient {

 @GetMapping("/app/org/{code}")
 OrganizationDto getOrganizationByCode(@PathVariable String code);
}
