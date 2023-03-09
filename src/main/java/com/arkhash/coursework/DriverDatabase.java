package com.arkhash.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DriverDatabase {
    private final ObservableList<Driver> drivers = FXCollections.observableArrayList();
    private final String filename;

    DriverDatabase(String filename) throws FileNotFoundException {
        this.filename = filename;
        File driverFile = new File(filename);
        Scanner fileReader = new Scanner(driverFile);
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            if (Utils.isEmpty(data)) {
                break;
            }
            String[] elements = data.split(",");
            // gets the elements to be stored into a list
            Driver driverStore = new Driver(elements[0], Utils.getNumber(elements[1]), elements[2], elements[3], Utils.getNumber(elements[4]), elements[5]);
            // the elements are added to the list.
            drivers.add(driverStore);
        }
        fileReader.close();
    }

    public ObservableList<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver) throws IOException {
        drivers.add(driver);
        FileWriter writer = new FileWriter(filename, true);
        writer.write(driver.getName() + "," + driver.getAge() + "," + driver.getTeam() + "," + driver.getModel() + "," + driver.getCurrentPoints() + "," + driver.getDriverID() + "\n");
        writer.close();
    }

    public boolean hasDriver(String driverID) {
        for (Driver driver: drivers) {
            if (driverID.equals(driver.getDriverID())) {
                return true;
            }
        }
        return false;
    }
}
