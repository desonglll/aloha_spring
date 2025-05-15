package com.sd.alohaspring.exception;

import com.sd.alohaspring.common.ErrorResponse;
import com.sd.alohaspring.exception.repository.EntityDuplicatedException;
import com.sd.alohaspring.exception.repository.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message, String detail) {
        return ResponseEntity.status(status).body(ErrorResponse.error(status.value(), message, detail));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Entity Not Found.", ex.getMessage());
    }

    @ExceptionHandler(EntityDuplicatedException.class)
    public ResponseEntity<ErrorResponse> handleEntityDuplicated(EntityDuplicatedException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Entity Duplicated.", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ex.printStackTrace();
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR.", ex.getMessage());
    }
}
