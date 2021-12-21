package com.pavel.adoptions.service.exceptions;

public class AnimalShelterNotFoundException extends  RuntimeException{
    public AnimalShelterNotFoundException(String message) {
        super(message);
    }
}
