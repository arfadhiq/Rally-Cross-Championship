package com.example.cwfx;

public class Driver {
    String name;
    int age;
    String team;
    String car;
    int points;

    public Driver(String name1, int age1, String team1, String car1, int points1) {
        this.name = name1;
        this.age = age1;
        this.team = team1;
        this.car = car1;
        this.points = points1;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public String getCar() {
        return car;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
