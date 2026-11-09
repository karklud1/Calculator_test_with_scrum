package com.example.calculator.bil;

public class CalculatorLogic {
    private char operator = ' ';

    private double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double minus(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double divide(double firstNumber, double secondNumber) {
        if (secondNumber != 0) {
            return firstNumber / secondNumber;
        } else return 0;
    }

    private double calculate(double firstNumber, double secondNumber) {
        return switch (operator) {
            case '+' -> add(firstNumber, secondNumber);
            case '-' -> minus(firstNumber, secondNumber);
            case '*' -> multiply(firstNumber, secondNumber);
            case '/' -> divide(firstNumber, secondNumber);
            default -> 0;
        };
    }

}
