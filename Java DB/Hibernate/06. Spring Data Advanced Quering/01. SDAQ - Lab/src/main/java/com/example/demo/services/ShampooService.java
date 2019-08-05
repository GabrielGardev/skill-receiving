package com.example.demo.services;

import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ShampooService {
    List<String> findAllBySize(Size size);
    List<String> findAllBySizeAndId(Size size, long id);
    List<String> findAllByPriceHigherThen(BigDecimal price);
    String findAllGroupedByPrice(BigDecimal price);
    List<String> findShampoosByIngredientsCount(int num);
    String findPriceOfIngredients(String name);
}
