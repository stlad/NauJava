package ru.naumen.vagnov.naujava.controller.handler;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEntityNotFound(EntityNotFoundException ex){
        log.error(ex.getMessage() + " | " + ex.getClass().getName());
        return new ResponseEntity<>(new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ex.getClass().getName()), HttpStatus.NOT_FOUND);
    }
}

@Data
@AllArgsConstructor
class ErrorDTO {
    private Integer code;
    private String msg;
    private String error;
}
