package com.pavel.adoptions.examples;

import com.pavel.adoptions.model.AnimalDTO;
import com.pavel.adoptions.model.CatDTO;

public class OopExample {
    public static void main(String[] args) {
        AnimalDTO animal1 = new AnimalDTO();
        AnimalDTO animal = new AnimalDTO("Hatchi", "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png",1);
        AnimalDTO animal3 = new AnimalDTO()
                .setName("Tom")
                .setPhotoUrl("photo");

        //Polymorphism
        CatDTO catDTO = new CatDTO("Tomi", "photo",1);
        AnimalDTO catAnimal=new CatDTO("boby","photo", 2);

        catDTO.speak();
        catAnimal.speak();

    }
}
