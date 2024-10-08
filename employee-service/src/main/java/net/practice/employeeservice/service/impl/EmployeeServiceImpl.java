package net.practice.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.practice.employeeservice.client.OrganizationClient;
import net.practice.employeeservice.dto.APIResponseDto;
import net.practice.employeeservice.dto.DepartmentDto;
import net.practice.employeeservice.dto.EmployeeDto;
import net.practice.employeeservice.dto.OrganizationDto;
import net.practice.employeeservice.entity.EmployeeEntity;
import net.practice.employeeservice.exception.NoEmployeeFoundException;
import net.practice.employeeservice.mapper.EmployeeMapper;
import net.practice.employeeservice.repository.EmployeesRepository;
import net.practice.employeeservice.client.DepartmentClient;
import net.practice.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private DepartmentClient feignClient;

    @Autowired
    private OrganizationClient organizationClient;



    @Override
    public EmployeeDto saveEmployeeDate(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = EmployeeMapper.mapDtoToEntity(employeeDto);

        EmployeeEntity savedEmployeeEntity =employeesRepository.save(employeeEntity);

        EmployeeDto employeeDtoSave = EmployeeMapper.mapToEntityToDto(savedEmployeeEntity);

        return employeeDtoSave;
    }

    @Override
    public APIResponseDto getEmployeesByID(Long id) {
        EmployeeEntity employeeEntity=employeesRepository.findById(id)
                .orElseThrow(()-> new NoEmployeeFoundException("Employee Not found with id -" + id));
    DepartmentDto departmentDto = feignClient.getDepartmentByCode(employeeEntity.getDepartmentCode());
    OrganizationDto organizationDto = organizationClient.getOrganizationByCode(employeeEntity.getOrganizationCode());
    EmployeeDto employeeDto = EmployeeMapper.mapToEntityToDto(employeeEntity);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }
}
