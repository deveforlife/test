package com.sat.backend_fasep.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class}) // {} Allows handling of multiple exceptions
    @ResponseStatus(HttpStatus.BAD_REQUEST) // status = 400
    public ErrorResponse handleValidationException(Exception e, WebRequest request){

        // log
        System.out.println("========> handleValidationException ");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setPath(request.getDescription(false).replace("uri=",""));

        // Cut the message string to get the error message
        String message = e.getMessage();
        if (e instanceof MethodArgumentNotValidException){
            errorResponse.setError("Payload Invalid");
            int start = message.lastIndexOf("[")+1;
            int end = message.lastIndexOf("]")-1;
            message = message.substring(start, end);
        } else if (e instanceof ConstraintViolationException) {
            errorResponse.setError("Parameter Invalid");
            message = message.substring(message.indexOf(" ") + 1);
        }
        errorResponse.setMessage(message);

        // return result
        return errorResponse;
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class}) // {} Allows handling of multiple exceptions
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // status = 400
    public ErrorResponse handleInternalServerErrorException(Exception e, WebRequest request){

        // log
        System.out.println("========> handleValidationException ");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setPath(request.getDescription(false).replace("uri=",""));
        errorResponse.setError("Parameter Invalid");

        if (e instanceof MethodArgumentTypeMismatchException){
            errorResponse.setMessage("Failed to convert value of type");
        }

        // return result
        return errorResponse;
    }
}
