package com.example.calculator.gui;

import com.example.calculator.bil.CalculatorLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

    public void onCalculate(ActionEvent actionEvent) throws IOException {
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

    public void onHistory(ActionEvent actionEvent) throws FileNotFoundException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(convertHistoryToString());
        alert.showAndWait();
    }

    private String convertHistoryToString() throws FileNotFoundException {
        StringBuilder returnString = new StringBuilder();
        List<String> data = calculatorLogic.readHistory();
        int length = Math.min(data.size(), 6);
        for (int i = data.size()-1; i > data.size() - length; i--) {
            returnString.append(data.get(i)).append("\n");
        }
        return returnString.toString();
    }
}
