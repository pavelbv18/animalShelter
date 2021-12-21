package com.pavel.adoptions.api;

import com.pavel.adoptions.model.DogDTO;
import com.pavel.adoptions.model.ListDTO;
import com.pavel.adoptions.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<DogDTO>> getAllDogs() {
        return ResponseEntity.ok(dogService.findAll());
    }

    @PostMapping
    public void addCat(@RequestBody DogDTO dogDto) {
        dogService.addDog(dogDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DogDTO> getDogByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(dogService.findDog(name));
    }
}


