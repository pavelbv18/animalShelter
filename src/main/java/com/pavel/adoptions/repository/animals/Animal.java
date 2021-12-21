package com.pavel.adoptions.repository.animals;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    protected String name;
    protected String photoUrl;

    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Animal setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}
