package com.arkhash.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    private final ArrayList<Driver> drivers = new ArrayList<>();

    @FXML
    private TextField nameField, ageField, teamField, modelField, pointsField, idField;
    @FXML
    private Label driverSaveDialog;
    int age;
    int initialPoints;

    // validates entries made by user
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

    //describes what happens when Submit button is clicked
    @FXML
    protected void onSubmitButtonClick() throws IOException {
        // performs the respective check
        if (isFieldInvalid(nameField)) {
            Utils.errorDialog("Please check the name again.");
            return;
        }

        // performs the respective check
        age = Utils.getNumber(ageField.getText());
        if (isFieldInvalid(ageField)) {
            Utils.errorDialog("Please check the age again.");
            return;
        }

        // performs the respective check
        if (isFieldInvalid(teamField)) {
            Utils.errorDialog("Please check the team name again.");
            return;
        }

        // performs the respective check
        if (isFieldInvalid(modelField)) {
            Utils.errorDialog("Please check the model again.");
            return;
        }

        // performs the respective check
        initialPoints = Utils.getNumber(pointsField.getText());
        if (isFieldInvalid(pointsField)) {
            Utils.errorDialog("Please check the championship points again.");
            return;
        }

        // performs the respective check
        if (isFieldInvalid(idField)) {
            Utils.errorDialog("Please check the ID again.");
            return;
        }
        onDriverStfButtonClick();

        // gets the elements to be stored into a list

    }
    public void onDriverStfButtonClick() throws IOException {
        Driver driverStore = new Driver(nameField.getText(), age, teamField.getText(), modelField.getText(), initialPoints, idField.getText());
        // the elements are added to the list.
        drivers.add(driverStore);

        FileWriter writer = new FileWriter("Driver details.txt", true);
        for (Driver driver : drivers) {
            writer.write(driverStore.getName() + "," + driverStore.getAge() + "," + driverStore.getTeam() + "," + driverStore.getModel() + "," + driverStore.getCurrentPoints() + "," + driverStore.getDriverID() + "\n");
        }
        writer.close();
        driverSaveDialog.setText("The driver details have been saved successfully!");
    }
}
