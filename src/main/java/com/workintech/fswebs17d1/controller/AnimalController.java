package com.workintech.fswebs17d1.controller;
import org.springframework.beans.factory.annotation.Value;
import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    // [GET] tüm hayvanları getir
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    // [GET] id'ye göre hayvan getir
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    // [POST] yeni hayvan ekle
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    // [PUT] hayvan güncelle
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id,
                               @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;
    }

    // [DELETE] hayvan sil
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
        return "Animal deleted: " + id;
    }
    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;
//
}