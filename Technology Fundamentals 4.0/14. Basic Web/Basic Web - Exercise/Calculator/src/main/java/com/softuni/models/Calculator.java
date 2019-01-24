package com.softuni.models;

public class Calculator {
    private Double leftOperand;
    private String operator;
    private Double rightOperand;

    public Calculator(Double leftOperand, String operator, Double rightOperand) {
        this.leftOperand = leftOperand;
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public Calculator() {
    }

    public Double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(Double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(Double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public double calculate(){
        switch (this.operator){
            case "+":
                return this.leftOperand + this.rightOperand;
            case "-":
                return this.leftOperand - this.rightOperand;
            case "*":
                return this.leftOperand * this.rightOperand;
            case "/":
                return  this.leftOperand / this.rightOperand;
                default:
                    return 0d;
        }
    }
}
