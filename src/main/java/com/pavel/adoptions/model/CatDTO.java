package com.pavel.adoptions.model;

public class CatDTO extends AnimalDTO {

    public CatDTO(String name, String photoUrl, Integer id) {
        super(name, photoUrl, id);
    }

    public void iAmACat() {
        System.out.println("Cats are specials!");
    }

    @Override
    public void speak() {
        System.out.println("Cats speaks!");
    }
}