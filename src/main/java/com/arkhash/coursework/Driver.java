package com.arkhash.coursework;

public class Driver {
    private String name;
    private int age;
    private String team;
    private String model;
    private int currentPoints;
    private String driverID;

    Driver(String name, int age, String team, String model, int currentPoints, String driverID) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.model = model;
        this.currentPoints = currentPoints;
        this.driverID = driverID;
    }


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTeam() {
        return this.team;
    }

    public String getModel() {
        return this.model;
    }

    public int getCurrentPoints() {
        return this.currentPoints;
    }

    public String getDriverID() {
        return this.driverID;
    }
}
