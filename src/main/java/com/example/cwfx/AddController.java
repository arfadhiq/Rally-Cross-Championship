package com.example.cwfx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddController {

    @FXML
    private TextField agenew;

    @FXML
    private Label agenewerror;
    @FXML
    private TextField namenew;
    @FXML
    private TextField carnew;
    @FXML
    private TextField pointsnew;
    @FXML
    private TextField teamnew;
    @FXML
    private Button backnew;
    @FXML
    private Button savenew;
    @FXML
    private Label namenewerror;
    @FXML
    private Label pointsnewerror;

    @FXML
    private Label carnewerror;

    @FXML
    private Label teamnewerror;
    @FXML
    private Label addMsg;


    public static ArrayList<Driver> driverlist = new ArrayList<Driver>();
    public void addDriver(){
        String name = namenew.getText().toUpperCase();
        String age = agenew.getText();
        String car = carnew.getText();
        String points = pointsnew.getText();
        String team = teamnew.getText();
        addMsg.setText(" ");

        if (addName(name,namenewerror) && addAge(age, agenewerror) && addCar(car,carnewerror) && addPoints(points,pointsnewerror) && addTeam(team,teamnewerror)) {
            namenewerror.setText("");
            agenewerror.setText("");
            teamnewerror.setText("");
            carnewerror.setText("");
            pointsnewerror.setText("");

            Driver driver = new Driver(name,Integer.parseInt(age),team,car,Integer.parseInt(points));
            driverlist.add(driver);
            addMsg.setText("Driver added successfully...");

            namenew.clear();
            agenew.clear();
            carnew.clear();
            pointsnew.clear();
            teamnew.clear();
        }
    }

    public void ageControl(){
        if (agenew.getText().isEmpty()){
            agenewerror.setText("age cannot be empty");
        } else if (agenew.getText().matches("[0-9]*")) {
            return;

        }else {
            agenewerror.setText("age should be a number!!!");
        }

    }

    public void setBacknew(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();


    }



    public boolean addName(String name, Label nameEr ){
        if (name.equals("")) {
            nameEr.setText("Name cannot be empty");
            return false;
        }
        else
            nameEr.setText("");
        for (int i = 0; i < driverlist.size(); i++){
            if (driverlist.get(i).getName().toUpperCase().equals(name)){
                nameEr.setText("Name already exists");
                return false;
            }
        }
        return true;
    }
    public boolean addAge(String age1 ,Label ageEr) {
        try {
            int age = Integer.parseInt(age1);
            if (age < 18 || age > 60) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            ageEr.setText("Age should be a number between 18 - 60 !");
            return false;
        }
        return true;
    }
    public boolean addCar(String car1 , Label carEr){
        if (car1.equals("")) {
            carEr.setText("Car name cannot be empty");
            return false;
        }carEr.setText("");
        return true;

    }
    public boolean addTeam(String team1, Label teamEr){
        if (team1.equals("")) {
            teamEr.setText("Team name cannot be empty");
            return false;
        }teamEr.setText("");
        return true;
    }
    public boolean addPoints(String points1, Label pointsEr) {
        try {
            int points = Integer.parseInt(points1);
            if (points < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            pointsEr.setText("points should be a number greater than 0");
            return false;
        }
        return true;
    }



}
