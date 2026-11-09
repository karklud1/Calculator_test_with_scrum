package com.example.calculator.gui;

import com.example.calculator.bil.CalculatorLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSubtract;
    @FXML
    private Button btnMultiply;
    @FXML
    private Button btnDivide;
    @FXML
    private TextField txtFirstNumber;
    @FXML
    private Label lblOperator;
    @FXML
    private TextField txtSecondNumber;
    @FXML
    private Button btnCalculator;
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
        if (!txtFirstNumber.getText().isEmpty() && !txtSecondNumber.getText().isEmpty()){
            lblResult.setText(calculatorLogic.calculate(Double.parseDouble(txtFirstNumber.getText()), Double.parseDouble(txtSecondNumber.getText())) + "");
        }
    }
}
