package com.loumo.exceptions;


import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {


    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionError exception = ExceptionError.builder()
                .type("ERROR")
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            exception.setDetail(error.getDefaultMessage());
        });
        ex.printStackTrace();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AppException.class})
    public ResponseEntity<Object> handleRvException(AppException appException, WebRequest request) {
        ExceptionError message = ExceptionError.builder()
                .type(appException.getType())
                .code(appException.getCode())
                .status(appException.getHttpStatus().value())
                .detail(appException.getDetail())
                .build();
        appException.printStackTrace();
        return new ResponseEntity<>(message, appException.getHttpStatus());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionError> handleException(Exception rvException) {
        ExceptionError exception = ExceptionError.builder()
                .type("ERROR")
                .code(500)
                .status(500)
                .detail(rvException.getMessage())
                .build();
        rvException.printStackTrace();
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        ExceptionError exception = ExceptionError.builder()
                .type("ERROR")
                .code(HttpStatus.FORBIDDEN.value())
                .status(HttpStatus.FORBIDDEN.value())
                .detail(ex.getMessage())
                .build();
        ex.printStackTrace();
        return new ResponseEntity<>(exception, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({JsonParseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleJsonParseException(
            JsonParseException ex, WebRequest request) {
        ExceptionError exception = ExceptionError.builder()
                .type("ERROR")
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.value())
                .detail("Formatage error")
                .build();
        ex.printStackTrace();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }


}
