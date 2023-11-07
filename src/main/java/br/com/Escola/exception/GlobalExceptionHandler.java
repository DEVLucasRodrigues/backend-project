package br.com.Escola.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<br.com.Escola.exception.CustomExceptionResponse>
                handleAllExceptions(Exception e,WebRequest request){
        br.com.Escola.exception.CustomExceptionResponse response = new br.com.Escola.exception.CustomExceptionResponse(new Date(),
                e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(br.com.Escola.exception.ResourceNotFoundException.class)
    public final ResponseEntity<br.com.Escola.exception.CustomExceptionResponse>
        handleResourceNotFoundException(Exception e,WebRequest request){
        br.com.Escola.exception.CustomExceptionResponse response = new br.com.Escola.exception.CustomExceptionResponse(new Date(),
                e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }









}
