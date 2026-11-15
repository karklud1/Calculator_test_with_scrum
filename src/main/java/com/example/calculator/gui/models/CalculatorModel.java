package com.example.calculator.gui.models;

import com.example.calculator.bll.CalculatorLogic;

public class CalculatorModel {
    CalculatorLogic calculatorLogic;
    public CalculatorModel(){
        calculatorLogic = new CalculatorLogic();
    }
}
