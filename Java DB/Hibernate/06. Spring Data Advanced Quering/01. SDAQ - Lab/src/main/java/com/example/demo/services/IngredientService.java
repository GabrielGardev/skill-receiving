package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public interface IngredientService {
    List<String> findAllStartsWith(String letters);

    List<String> findAllInListByName(Set<String> names);

    List<String> findShampoosByIngredients(Set<Ingredient> ingredients);

    Ingredient findByName(String name);

    void deleteByName(String name);

    void updatePrice(double percent);

    void updatePrice(Set<String> names, double percent);
}
