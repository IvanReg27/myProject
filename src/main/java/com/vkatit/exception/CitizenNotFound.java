package com.vkatit.exception;

public class CitizenNotFound extends RuntimeException {
    public CitizenNotFound() {
        super();
    }
    public CitizenNotFound(String message) {
        super(message);
    }
}