package net.practice.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponseDto {
    private int statusCode;
    private String message;
    private String details;
}
