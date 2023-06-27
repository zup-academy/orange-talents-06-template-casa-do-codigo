package com.projeto.casadocodigo.config.handling;


import com.projeto.casadocodigo.service.exception.CreateCategoryServiceException;
import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<GenericErrorResponse> handle(ServiceException exception) {
        if (exception instanceof CreateCategoryServiceException){
            int code = HttpStatus.BAD_REQUEST.value();
            String error = HttpStatus.BAD_REQUEST.getReasonPhrase();
            String errorMessage = exception.getMessage();
            GenericErrorResponse genericErrorResponse = new GenericErrorResponse(code, error, errorMessage);
            return ResponseEntity.status(code).body(genericErrorResponse);
        }else if(exception instanceof ExistsEmailServiceException){
            int code = HttpStatus.CONFLICT.value();
            String error = HttpStatus.CONFLICT.getReasonPhrase();
            String errorMessage = exception.getMessage();
            GenericErrorResponse genericErrorResponse = new GenericErrorResponse(code, error, errorMessage);
            return ResponseEntity.status(code).body(genericErrorResponse);
        }
        // Caso não seja uma exception filha conhecida
        int code = HttpStatus.BAD_REQUEST.value();
        String error = HttpStatus.BAD_REQUEST.getReasonPhrase();
        String errorMessage = exception.getMessage();
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(code, error, errorMessage);
        return ResponseEntity.status(code).body(genericErrorResponse);
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        String errorMessage = "Erro de validação";
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.add(fieldError.getDefaultMessage());
        }
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage, errors.toString());
        return genericErrorResponse;
    }
}
