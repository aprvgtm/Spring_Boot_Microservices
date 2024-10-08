package net.practice.employeeservice.exception;

import lombok.AllArgsConstructor;
import net.practice.employeeservice.dto.EmployeeDto;
import net.practice.employeeservice.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoEmployeeFoundException.class)
    public ResponseEntity<ErrorResponseDto> employeeNotfound(NoEmployeeFoundException ex, WebRequest webRequest){
      ErrorResponseDto errorResponseDto = new ErrorResponseDto(
           HttpStatus.NOT_FOUND.value(),
              ex.getMessage(),
            webRequest.getDescription(false)
      );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    // create global exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> globalException(Exception ex, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoDepartmentFoundException.class)
    public ResponseEntity<ErrorResponseDto> NoDepartmentFoundException(NoDepartmentFoundException e, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
