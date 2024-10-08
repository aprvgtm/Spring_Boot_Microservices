package net.practice.departmentservice.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.practice.departmentservice.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@AllArgsConstructor
@NoArgsConstructor
public class GlobalExceptionHandler {

    public ErrorResponseDto errorResponse;

    @ExceptionHandler(NoDepartmentFound.class)
    public ResponseEntity<ErrorResponseDto> noDepartmentFound(NoDepartmentFound ex, WebRequest request){
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //GLobal Exception Handler
    public ResponseEntity<ErrorResponseDto> globalException(Exception e, WebRequest request){
      errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
      errorResponse.setMessage(e.getMessage());
      errorResponse.setDetails(request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
