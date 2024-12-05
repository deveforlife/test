package com.sat.backend_fasep.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

public class ResponseData<T> {
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL) // do not display null values
    private T data;

    // PUT, PATCH, DELETE
    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // POST, GET
    public ResponseData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
