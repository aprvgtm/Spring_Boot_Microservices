package net.practice.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.practice.departmentservice.dto.DepartmentDto;
import net.practice.departmentservice.entity.Department;
import net.practice.departmentservice.exception.NoDepartmentFound;
import net.practice.departmentservice.mapper.DepartmentMapper;
import net.practice.departmentservice.repository.DepartmentRepository;
import net.practice.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapDtoToEntity(departmentDto);

        Department saveDepartment = departmentRepository.save(department);

        DepartmentDto departmentDto1 = DepartmentMapper.mapEntityToDto(saveDepartment);
        return departmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

       Department department= departmentRepository.findByDepartmentCode(departmentCode);
      if(department != null && departmentCode !=null) {
          DepartmentDto departmentDto = DepartmentMapper.mapEntityToDto(department);
          return departmentDto;
      }else {
          throw new NoDepartmentFound("No department found with this code -" + departmentCode);
      }
    }
}
