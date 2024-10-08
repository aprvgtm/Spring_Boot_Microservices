package net.practice.employeeservice.repository;

import net.practice.employeeservice.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {
}
