package com.arkhash.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    private final ArrayList<Driver> drivers = new ArrayList<>();

    @FXML
    private TextField nameField, ageField, teamField, modelField, pointsField, idField;



    @FXML
    protected void onNameChanged() {
        System.out.println("hello");
    }

    @FXML
    protected void onSubmitButtonClick() throws IOException {
        // performs the respective check
        if (Utils.hasSpecialCharacters(nameField.getText())) {
            Utils.errorDialog("Please check the name again.");
            return;
        }

        int age = Utils.getNumber(ageField.getText());
        if (age == -1) {
            Utils.errorDialog("Please check the age again.");
            return;
        }

        if (ageField.getText() == null) {
            Utils.errorDialog("Please check the age again.");
            return;
        }

        if (Utils.hasSpecialCharacters(teamField.getText())) {
            Utils.errorDialog("Please check the team name again.");
            return;
        }

        if (Utils.hasSpaces(modelField.getText())) {
            Utils.errorDialog("Please check the model again.");
            return;
        }

        if (Utils.hasSpaces(idField.getText())) {
            Utils.errorDialog("Please check the ID again.");
            return;
        }

        int initialPoints = Utils.getNumber(pointsField.getText());
        if (initialPoints == -1) {
            Utils.errorDialog("Please check the championship points again.");
            return;
        }

        if (pointsField.getText() == null) {
            Utils.errorDialog("Please check the championship points again.");
            return;
        }

        Driver driverStore = new Driver(nameField.getText(), age, teamField.getText(), modelField.getText(), initialPoints, idField.getText());
        drivers.add(driverStore);


    }
}
