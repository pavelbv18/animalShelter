package com.pavel.adoptions.service;

import com.pavel.adoptions.model.CatDTO;
import com.pavel.adoptions.model.ListDTO;
import com.pavel.adoptions.model.adapters.CatAdapter;
import com.pavel.adoptions.repository.cats.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(CatDTO catDto) {
        if (catDto.getName() == null & catDto.getPhotoUrl() == null) {
            throw new RuntimeException("Cats must have a name and a photo!");
        }
        catRepository.save(CatAdapter.fromDto(catDto));
    }

    public ListDTO<CatDTO> findAll() {

        List<CatDTO> cats = CatAdapter.toListDto(catRepository.findAll().stream().filter(cat -> cat.getId() != 2).collect(Collectors.toList()));
        long totalCount = catRepository.count();
        return new ListDTO<>((int) totalCount, cats);
    }

    public CatDTO findCat(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("Must specify name!");
        }
        return CatAdapter.toDto(catRepository.findCatByName(name));
    }
}
