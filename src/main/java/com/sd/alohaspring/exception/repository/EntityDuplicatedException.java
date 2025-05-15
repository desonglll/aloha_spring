package com.sd.alohaspring.exception.repository;

public class EntityDuplicatedException extends RuntimeException {
    public EntityDuplicatedException(String message) {
        super(message);
    }
}
