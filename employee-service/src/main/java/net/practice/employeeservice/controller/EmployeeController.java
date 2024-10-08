package net.practice.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.practice.employeeservice.dto.APIResponseDto;
import net.practice.employeeservice.dto.EmployeeDto;
import net.practice.employeeservice.entity.EmployeeEntity;
import net.practice.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee-Service EmployeeController",
        description = "This is Employee controller service. "
)
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // Custom Swagger Api documentation.................
    @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee data into data base"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status code 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployees(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1=employeeService.saveEmployeeDate(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    // Custom Swagger Api documentation.................
    @Operation(
            summary = "Get Employee REST API",
            description = "get Employee data from data base"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status code 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getByID(@PathVariable Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeesByID(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
