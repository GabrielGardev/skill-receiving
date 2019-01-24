package com.softuni.controller;

import com.softuni.models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("operator", "+");
        model.addAttribute("view", "views/calculatorForm");
        return "base-layout";
    }

    @PostMapping("/")
    public String calculate(@RequestParam("leftOperand") String leftOperandStr,
                            @RequestParam("operator") String operatorStr,
                            @RequestParam("rightOperand") String rightOperandStr,
                            Model model) {

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(leftOperandStr);
        } catch (NumberFormatException ex) {
            num1 = 0d;
        }

        try {
            num2 = Double.parseDouble(rightOperandStr);
        } catch (NumberFormatException ex) {
            num2 = 0d;
        }

        Calculator calculator = new Calculator(num1, operatorStr, num2);
        double result = calculator.calculate();

        model.addAttribute("leftOperand", calculator.getLeftOperand());
        model.addAttribute("operator", calculator.getOperator());
        model.addAttribute("rightOperand", calculator.getRightOperand());

        model.addAttribute("result", result);

        model.addAttribute("view", "views/calculatorForm");

        return "base-layout";
    }
}
