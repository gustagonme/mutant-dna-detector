package com.mutant.dna.detector.exception;

import org.springframework.http.HttpStatus;

public class MutantDnaException {

    private HttpStatus status;
    private String message;


    public MutantDnaException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus httpStatus) {
        this.status = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
