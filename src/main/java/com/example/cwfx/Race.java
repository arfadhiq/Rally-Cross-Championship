package com.example.cwfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Race {
    String location;
    String date1;

    AddController addController= new AddController();
    int n= addController.driverlist.size();

    String[] drivers = new String[n];

    public Race(String date,String location , String[] drivers){
        this.date1 = date;
        this.location = location;
        this.drivers = drivers;
    }


}
