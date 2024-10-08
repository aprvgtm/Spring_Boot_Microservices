package net.practice.employeeservice.mapper;

import net.practice.employeeservice.dto.EmployeeDto;
import net.practice.employeeservice.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDto mapToEntityToDto(EmployeeEntity employeeEntity){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeEntity.getId());
        employeeDto.setFirstName(employeeEntity.getFirstName());
        employeeDto.setLastName(employeeEntity.getLastName());
        employeeDto.setEmail(employeeEntity.getEmail());
        employeeDto.setDepartmentCode(employeeEntity.getDepartmentCode());
        employeeDto.setOrganizationCode(employeeEntity.getOrganizationCode());
        return employeeDto;
    }

    public static EmployeeEntity mapDtoToEntity(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDto.getId());
        employeeEntity.setFirstName(employeeDto.getFirstName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setDepartmentCode(employeeDto.getDepartmentCode());
        employeeEntity.setOrganizationCode(employeeDto.getOrganizationCode());
        return employeeEntity;
    }
}
