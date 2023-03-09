package com.arkhash.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    private final DriverDatabase drivers = new DriverDatabase("Driver Details.txt");

    @FXML
    private TextField nameField, ageField, teamField, modelField, pointsField, idField;

    @FXML
    private TableView<Driver> championshipTable;

    public MainController() throws FileNotFoundException {}

    public void initialize() {
        @SuppressWarnings("unchecked")
        TableColumn<Driver, String> id = (TableColumn<Driver, String>) championshipTable.getColumns().get(0);
        id.setCellValueFactory(new PropertyValueFactory<>("driverID"));

        @SuppressWarnings("unchecked")
        TableColumn<Driver, String> name = (TableColumn<Driver, String>) championshipTable.getColumns().get(1);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        @SuppressWarnings("unchecked")
        TableColumn<Driver, String> age = (TableColumn<Driver, String>) championshipTable.getColumns().get(2);
        age.setCellValueFactory(new PropertyValueFactory<>("age"));

        @SuppressWarnings("unchecked")
        TableColumn<Driver, String> teamName = (TableColumn<Driver, String>) championshipTable.getColumns().get(3);
        teamName.setCellValueFactory(new PropertyValueFactory<>("team"));

        @SuppressWarnings("unchecked")
        TableColumn<Driver, String> model = (TableColumn<Driver, String>) championshipTable.getColumns().get(4);
        model.setCellValueFactory(new PropertyValueFactory<>("model"));

        @SuppressWarnings("unchecked")
        TableColumn<Driver, String> currentPoints = (TableColumn<Driver, String>) championshipTable.getColumns().get(5);
        currentPoints.setCellValueFactory(new PropertyValueFactory<>("currentPoints"));
        currentPoints.setSortType(TableColumn.SortType.DESCENDING);

        championshipTable.setItems(drivers.getDrivers());

        championshipTable.getSortOrder().add(currentPoints);
        championshipTable.sort();

    }


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
            return Utils.hasCommas(field.getText());
        } else if (field == pointsField) {
            int points = Utils.getNumber(field.getText());
            return points == -1;
        } else {
            return Utils.hasCommas(field.getText()) || drivers.hasDriver(field.getText());
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
        int age = Utils.getNumber(ageField.getText());
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
        int initialPoints = Utils.getNumber(pointsField.getText());
        if (isFieldInvalid(pointsField)) {
            Utils.errorDialog("Please check the championship points again.");
            return;
        }

        // performs the respective check
        if (isFieldInvalid(idField)) {
            Utils.errorDialog("Please check the ID again.");
            return;
        }

        addDriver(age, initialPoints);
    }

    private void addDriver(int age, int initialPoints) throws IOException {
        // gets the elements to be stored into a list
        Driver driverStore = new Driver(nameField.getText(), age, teamField.getText(), modelField.getText(), initialPoints, idField.getText());
        // the elements are added to the list.
        drivers.addDriver(driverStore);
        Utils.successDialog("The driver has been added successfully.");
    }
}
