package com.pavel.adoptions.service;

import com.pavel.adoptions.model.DogDTO;
import com.pavel.adoptions.model.ListDTO;
import com.pavel.adoptions.model.adapters.DogAdapter;
import com.pavel.adoptions.repository.dogs.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogService {
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void addDog(DogDTO dogDto) {
        if (dogDto.getName() == null & dogDto.getPhotoUrl() == null) {
            throw new RuntimeException("Dogs must have a name and a photo!");
        }
        dogRepository.save(DogAdapter.fromDto(dogDto));
    }
    public ListDTO<DogDTO> findAll() {

        List<DogDTO> dogs = DogAdapter.toListDto(dogRepository.findAll().stream().filter(dog -> dog.getId() != 2).collect(Collectors.toList()));
        long totalCount = dogRepository.count();
        return new ListDTO<>((int) totalCount, dogs);
    }

    public DogDTO findDog(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("Must specify name!");
        }
        return DogAdapter.toDto(dogRepository.findDogByName(name));
    }
}
