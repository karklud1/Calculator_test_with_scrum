package com.example.calculator.gui;

import com.example.calculator.bil.CalculatorLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField txtFirstNumber;
    @FXML
    private Label lblOperator;
    @FXML
    private TextField txtSecondNumber;
    @FXML
    private Label lblResult;

    CalculatorLogic calculatorLogic = new CalculatorLogic();

    public void onAdd(ActionEvent actionEvent) {
        lblOperator.setText("+");
        calculatorLogic.setOperator('+');
    }

    public void onSubtract(ActionEvent actionEvent) {
        lblOperator.setText("-");
        calculatorLogic.setOperator('-');
    }

    public void onMultiply(ActionEvent actionEvent) {
        lblOperator.setText("*");
        calculatorLogic.setOperator('*');
    }

    public void onDivide(ActionEvent actionEvent) {
        lblOperator.setText("/");
        calculatorLogic.setOperator('/');
    }

    public void onCalculate(ActionEvent actionEvent) {
        if (!txtFirstNumber.getText().isEmpty() && !txtSecondNumber.getText().isEmpty()) {
            if (calculatorLogic.getOperator() == '/' && Double.parseDouble(txtSecondNumber.getText()) == 0) {
                lblResult.setText("Error: Kan ikke dividere med 0");
            } else {
                lblResult.setText(calculatorLogic.calculate(Double.parseDouble(txtFirstNumber.getText()), Double.parseDouble(txtSecondNumber.getText())) + "");
            }
        }
    }

    public void onClear(ActionEvent actionEvent) {
        txtFirstNumber.clear();
        txtSecondNumber.clear();
        lblOperator.setText("");
        lblResult.setText("");
        calculatorLogic.setOperator(' ');
    }
}
