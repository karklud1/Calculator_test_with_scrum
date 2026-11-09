package com.example.calculator.bil;

import com.example.calculator.dal.HistoryDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CalculatorLogic {
    private char operator = ' ';
    HistoryDAO historyDAO = new HistoryDAO();
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

    public double calculate(double firstNumber, double secondNumber) throws IOException {
        double result = 0;
        switch (operator) {
            case '+' -> result = add(firstNumber, secondNumber);
            case '-' -> result = minus(firstNumber, secondNumber);
            case '*' -> result = multiply(firstNumber, secondNumber);
            case '/' -> result = divide(firstNumber, secondNumber);
            default -> result = 0;
        };
        historyDAO.writeToFile(convertToString(firstNumber, secondNumber, result));
        return result;
    }

    public void setOperator(char operator){
        this.operator = operator;
    }

    public char getOperator(){
        return operator;
    }

    private String convertToString(double firstNumber, double secondNumber, double result){
        return firstNumber + " " + operator + " " + secondNumber + " = " + result;
    }

    public List<String> readHistory() throws FileNotFoundException {
        return historyDAO.readFromFile();
    }

}
