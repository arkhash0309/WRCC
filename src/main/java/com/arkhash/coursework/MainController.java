package com.arkhash.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    private final ArrayList<Driver> drivers = new ArrayList<>();

    @FXML
    private TextField nameField, ageField, teamField, modelField, pointsField, idField;

    private boolean isFieldInvalid(TextField field) {
        if (field == nameField) {
            return Utils.hasSpecialCharacters(field.getText());
        } else if (field == ageField) {
            int age = Utils.getNumber(field.getText());
            return age == -1;
        } else if (field == teamField) {
            return Utils.hasSpecialCharacters(field.getText());
        } else if (field == modelField) {
            return Utils.isEmpty(field.getText());
        } else if (field == pointsField) {
            int points = Utils.getNumber(field.getText());
            return points == -1;
        } else {
            return Utils.isEmpty(field.getText());
        }
    }

    @FXML
    protected void onTextChanged(KeyEvent e) {
        TextField field = (TextField) e.getSource();
        field.getStyleClass().remove("invalid-field");
        field.getStyleClass().remove("valid-field");
        if (isFieldInvalid(field)) {
            field.getStyleClass().add("invalid-field");
        } else {
            field.getStyleClass().add("valid-field");
        }
    }

    @FXML
    protected void onSubmitButtonClick() throws IOException {
        // performs the respective check
        if (isFieldInvalid(nameField)) {
            Utils.errorDialog("Please check the name again.");
            return;
        }

        int age = Utils.getNumber(ageField.getText());
        if (isFieldInvalid(ageField)) {
            Utils.errorDialog("Please check the age again.");
            return;
        }

        if (isFieldInvalid(teamField)) {
            Utils.errorDialog("Please check the team name again.");
            return;
        }

        if (isFieldInvalid(modelField)) {
            Utils.errorDialog("Please check the model again.");
            return;
        }

        if (isFieldInvalid(idField)) {
            Utils.errorDialog("Please check the ID again.");
            return;
        }

        int initialPoints = Utils.getNumber(pointsField.getText());
        if (isFieldInvalid(pointsField)) {
            Utils.errorDialog("Please check the championship points again.");
            return;
        }

        Driver driverStore = new Driver(nameField.getText(), age, teamField.getText(), modelField.getText(), initialPoints, idField.getText());
        drivers.add(driverStore);
    }
}
