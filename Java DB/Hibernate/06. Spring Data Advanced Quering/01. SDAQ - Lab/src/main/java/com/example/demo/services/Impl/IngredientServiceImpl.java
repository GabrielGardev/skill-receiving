package com.example.demo.services.Impl;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Shampoo;
import com.example.demo.repositories.IngredientRepository;
import com.example.demo.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> findAllStartsWith(String letters) {
        return this.ingredientRepository.findAllByNameStartsWith(letters)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllInListByName(Set<String> names) {
        return this.ingredientRepository.findAllByNameOrderByPrice(names)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findShampoosByIngredients(Set<Ingredient> ingredients) {
        return this.ingredientRepository.findByIngredientsIn(ingredients)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }

    @Override
    public Ingredient findByName(String name) {
        return this.ingredientRepository.findByName(name);
    }

    @Override
    public void deleteByName(String name) {
        this.ingredientRepository.deleteByName(name);
    }

    @Override
    public void updatePrice(double percent) {
        percent = (percent / 100) + 1;
        this.ingredientRepository.updatePriceOfAllByPercent(BigDecimal.valueOf(percent));
    }

    @Override
    public void updatePrice(Set<String> names, double percent) {
        percent = (percent / 100) + 1;
        List<Ingredient> list = this.ingredientRepository.findAllByNameOrderByPrice(names);
        for (Ingredient ingredient : list) {
            ingredient.setPrice(ingredient.getPrice().multiply(BigDecimal.valueOf(percent)));
            this.ingredientRepository.saveAndFlush(ingredient);
        }
    }
}
