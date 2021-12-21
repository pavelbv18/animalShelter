package com.pavel.adoptions.repository.cats;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    Cat findCatByName(String name);

}
