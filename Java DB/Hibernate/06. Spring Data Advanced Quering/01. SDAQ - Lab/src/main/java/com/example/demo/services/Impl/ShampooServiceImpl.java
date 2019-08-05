package com.example.demo.services.Impl;

import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import com.example.demo.repositories.ShampooRepository;
import com.example.demo.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<String> findAllBySize(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size)
                .stream()
                .map(s -> String.format("%s %s %.2flv.",
                        s.getBrand(),
                        s.getSize(),
                        s.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBySizeAndId(Size size, long id) {
        return this.shampooRepository.findAllByIdOrSizeOrderByPrice(id, size)
                .stream()
                .map(s -> String.format("%s %s %.2flv.",
                        s.getBrand(),
                        s.getSize(),
                        s.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByPriceHigherThen(BigDecimal price) {
        return this.shampooRepository.findAllByPriceAfterOrderByPriceDesc(price)
                .stream()
                .map(s -> String.format("%s %s %.2flv.",
                        s.getBrand(),
                        s.getSize(),
                        s.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public String findAllGroupedByPrice(BigDecimal price) {
       return this.shampooRepository.findAllGroupedByPrice(price).get(0)[0].toString();
    }

    @Override
    public List<String> findShampoosByIngredientsCount(int num) {
        return this.shampooRepository.findAllByIngredientsLessThan(num)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }

    @Override
    public String findPriceOfIngredients(String name) {
        return this.shampooRepository.findPriceOfIngredients(name).get(0)[0].toString();
    }
}
