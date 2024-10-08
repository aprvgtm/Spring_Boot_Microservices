package net.practice.departmentservice.service;

import net.practice.departmentservice.dto.DepartmentDto;
import org.springframework.stereotype.Service;


public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);

}
