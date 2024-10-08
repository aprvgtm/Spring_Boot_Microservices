package net.practice.departmentservice.mapper;

import net.practice.departmentservice.dto.DepartmentDto;
import net.practice.departmentservice.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapEntityToDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        return departmentDto;
    }

    public static Department mapDtoToEntity(DepartmentDto departmentDto){
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        return department;
    }
}
