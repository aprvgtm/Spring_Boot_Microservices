package net.practice.employeeservice.service;

import net.practice.employeeservice.dto.APIResponseDto;
import net.practice.employeeservice.dto.EmployeeDto;
import org.springframework.stereotype.Service;


public interface EmployeeService {
  EmployeeDto saveEmployeeDate(EmployeeDto employeeDto);

  APIResponseDto getEmployeesByID(Long id);

}
