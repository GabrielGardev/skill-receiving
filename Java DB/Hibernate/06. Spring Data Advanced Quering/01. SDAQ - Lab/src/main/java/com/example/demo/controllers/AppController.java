package com.example.demo.controllers;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Size;
import com.example.demo.services.IngredientService;
import com.example.demo.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;
    private BufferedReader reader;

    @Autowired
    public AppController(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        int taskNum = Integer.parseInt(this.reader.readLine());

        switch (taskNum) {
            case 1:
                this.task1();
                break;
            case 2:
                this.task2();
                break;
            case 3:
                this.task3();
                break;
            case 4:
                this.task4();
                break;
            case 5:
                this.task5();
                break;
            case 6:
                this.task6();
                break;
            case 7:
                this.task7();
                break;
            case 8:
                this.task8();
                break;
            case 9:
                this.task9();
                break;
            case 10:
                this.task10();
                break;
            case 11:
                this.task11();
                break;
            case 12:
                this.task12();
                break;
        }

    }

    private void task12() throws IOException {
        Set<String> ingredients = new HashSet<>();
        while (true) {
            String line = reader.readLine();
            if (line.isBlank()) {
                break;
            }
            ingredients.add(line);
        }
        double percent = Double.parseDouble(reader.readLine());

        this.ingredientService.updatePrice(ingredients, percent);
    }

    private void task11() throws IOException {
        double percent = Double.parseDouble(reader.readLine());
        this.ingredientService.updatePrice(percent);
    }

    private void task10() throws IOException {
        String name = reader.readLine();
        this.ingredientService.deleteByName(name);
    }

    private void task9() throws IOException {
        String name = reader.readLine();
        System.out.println(this.shampooService.findPriceOfIngredients(name));
    }

    private void task8() throws IOException {
        int count = Integer.parseInt(reader.readLine());
        this.shampooService.findShampoosByIngredientsCount(count)
                .forEach(System.out::println);
    }

    private void task7() throws IOException {
        Set<Ingredient> ingredients = new HashSet<>();
        while (true) {
            String line = reader.readLine();
            if (line.isBlank()) {
                break;
            }
            ingredients.add(this.ingredientService.findByName(line));
        }
        this.ingredientService.findShampoosByIngredients(ingredients)
                .forEach(System.out::println);
    }

    private void task6() throws IOException {
        String val = reader.readLine();
        BigDecimal bigDecimal = new BigDecimal(val);
        System.out.println(this.shampooService.findAllGroupedByPrice(bigDecimal));
    }

    private void task5() {
        Set<String> names = Set.of(
                "Lavender",
                "Herbs",
                "Apple"
        );
        this.ingredientService.findAllInListByName(names)
                .forEach(System.out::println);
    }

    private void task4() throws IOException {
        String letters = reader.readLine();
        this.ingredientService.findAllStartsWith(letters)
                .forEach(System.out::println);
    }

    private void task3() throws IOException {
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
        this.shampooService.findAllByPriceHigherThen(price)
                .forEach(System.out::println);
    }

    private void task1() throws IOException {
        Size size = Size.valueOf(reader.readLine());
        this.shampooService.findAllBySize(size)
                .forEach(System.out::println);
    }

    private void task2() throws IOException {
        Size size = Size.valueOf(reader.readLine());
        long id = Integer.valueOf(reader.readLine());
        this.shampooService.findAllBySizeAndId(size, id)
                .forEach(System.out::println);
    }
}
