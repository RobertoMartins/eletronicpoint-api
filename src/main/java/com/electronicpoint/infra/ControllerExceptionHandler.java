package com.electronicpoint.infra;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.electronicpoint.dtos.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> threatDuplicateEntity(DataIntegrityViolationException exception) {

        ExceptionDTO responseException = new ExceptionDTO("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(responseException);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> threatNotFoundEntity(DataIntegrityViolationException exception) {

        ExceptionDTO responseException = new ExceptionDTO("Usuário não encontrado", "400");
        return ResponseEntity.badRequest().body(responseException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> threatGeneralException(Exception exception) {

        ExceptionDTO responseException = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(responseException);
    }

}
