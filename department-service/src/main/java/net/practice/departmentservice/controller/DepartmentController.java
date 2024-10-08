package net.practice.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.practice.departmentservice.dto.DepartmentDto;
import net.practice.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// Custom Swagger Api documentation.................
@Tag(
        name = "Department Service - DepartmentController",
        description = "This is the Department service controller"
)
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Custom Swagger Api documentation.................
    @Operation(
            summary = "Save Department REST API",
            description = "Save Department data into data base"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status code 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
       DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }


    // Custom Swagger Api documentation.................
    @Operation(
            summary = "Get Department REST API",
            description = "get Department data from data base"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status code 200 OK"
    )
    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code){
      DepartmentDto departmentDto =  departmentService.getDepartmentByCode(code);
      return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
