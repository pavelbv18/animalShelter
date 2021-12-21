package com.pavel.adoptions.model.adapters;

import com.pavel.adoptions.model.DogDTO;
import com.pavel.adoptions.repository.dogs.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter {

    public static Dog fromDto(DogDTO dogDTO) {
        if (dogDTO.getName().equals("")) {
            dogDTO.setName("Generic name");
        }
        return (Dog) new Dog().setName(dogDTO.getName()).setPhotoUrl(dogDTO.getPhotoUrl());
    }

    public static DogDTO toDto(Dog dog) {
        return new DogDTO(dog.getName(), dog.getPhotoUrl(), dog.getId());
    }

    public static List<DogDTO> toListDto(List<Dog> dogList) {
        List<DogDTO> dtoList = new ArrayList<>();
        dogList.forEach(dog -> dtoList.add(toDto(dog)));
        return dtoList;
    }
}

