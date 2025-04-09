package br.com.amaurygomes.zylo.exception;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PlanNotFoundException.class)
    private ResponseEntity<ExceptionMessage> planNotFountHandler(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionMessage(
                        HttpStatus.NOT_FOUND,
                        e.getMessage()
                ));
    }

    @ExceptionHandler(DuplicatePlanException.class)
    private ResponseEntity<ExceptionMessage> duplicatePlanHandler(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionMessage(
                        HttpStatus.CONFLICT,
                        e.getMessage()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ExceptionMessage> methodArgumentNotValidHandler(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionMessage(
                        HttpStatus.BAD_REQUEST,
                        e.getBindingResult().getFieldError().getDefaultMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ExceptionMessage> defaultExceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionMessage(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "An unexpected error has occurred. Please contact support if the issue persists."
                ));
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<ExceptionMessage> runtimeExceptionHandler(RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionMessage(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "An unexpected error has occurred. Please contact support if the issue persists."
                ));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity<ExceptionMessage> noResourceFoundHandler(NoResourceFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionMessage(
                        HttpStatus.NOT_FOUND,
                        "The requested resource was not found."
                ));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<ExceptionMessage> methodArgumentTypeMismatchHandler(MethodArgumentTypeMismatchException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionMessage(
                        HttpStatus.BAD_REQUEST,
                        "Invalid parameter format. Please check the value and try again."
                ));
    }

    @ExceptionHandler(EntityExistsException.class)
    private ResponseEntity<ExceptionMessage> entityExistsHandler(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionMessage(
                        HttpStatus.CONFLICT,
                        "The requested resource already exists. Please try again with a different name."
                ));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ExceptionMessage> httpMessageNotReadableHandler(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionMessage(
                        HttpStatus.BAD_REQUEST,
                        "Invalid parameter format. Please check the value and try again."
                ));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<ExceptionMessage> httpRequestMethodNotSupportedHandler(Exception e){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new ExceptionMessage(
                        HttpStatus.METHOD_NOT_ALLOWED,
                        "The requested method is not allowed. Please check the URL and try again."
                ));
    }

}
