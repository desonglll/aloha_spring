package com.sd.alohaspring.exception.repository;

public class SaveEntityException extends RuntimeException {
    public SaveEntityException(String message) {
        super(message);
    }
}
