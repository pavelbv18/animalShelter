package com.pavel.adoptions.repository.dogs;


import com.pavel.adoptions.repository.animals.Animal;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {
 private String size;

    public Dog() {
    }

    public String getSize() {
        return size;
    }

    public Dog setSize(String size) {
        this.size = size;
        return this;
    }
}
