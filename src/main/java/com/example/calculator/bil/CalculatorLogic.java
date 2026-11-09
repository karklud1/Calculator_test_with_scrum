package com.example.calculator.bil;

public class CalculatorLogic {
    private char operator = ' ';

    private double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double calculate(double firstNumber, double secondNumber) {
        double result = 0;
        switch (operator) {
            case '+':
                result = add(firstNumber, secondNumber);
                break;
            case '-':
        }

        return result;
    }
}
