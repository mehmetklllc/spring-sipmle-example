package com.turkishh.ui.exceptions;

import com.turkishh.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String exceptionMessageDesc = ex.getLocalizedMessage();
        if(exceptionMessageDesc==null) exceptionMessageDesc = ex.toString();
        ErrorMessage errorMessage=new ErrorMessage(new Date(),exceptionMessageDesc);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest request) {

        String exceptionMessageDesc = ex.getLocalizedMessage();
        if(exceptionMessageDesc==null) exceptionMessageDesc = ex.toString();
        ErrorMessage errorMessage=new ErrorMessage(new Date(),exceptionMessageDesc);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UserServerException.class})
    public ResponseEntity<Object> handleUserServerException(Exception ex, WebRequest request) {

        String exceptionMessageDesc = ex.getLocalizedMessage();
        if(exceptionMessageDesc==null) exceptionMessageDesc = ex.toString();
        ErrorMessage errorMessage=new ErrorMessage(new Date(),exceptionMessageDesc);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}