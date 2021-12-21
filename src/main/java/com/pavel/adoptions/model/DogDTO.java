package com.pavel.adoptions.model;

public class DogDTO extends AnimalDTO {

    public DogDTO(String name, String photoUrl, Integer id) {
        super(name, photoUrl, id);
    }

    public void iAmADog() {
        System.out.println("Dogs are specials!");
    }

    @Override
    public void speak() {
        System.out.println("Dogs speaks!");
    }
}
