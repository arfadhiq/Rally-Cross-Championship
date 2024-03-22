package com.example.cwfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UDDController {


    @FXML
    private Label uddAgeEr;

    @FXML
    private Label uddCarEr;

    @FXML
    private Label uddNameEr;

    @FXML
    private Label uddPointsEr;
    @FXML
    private Label uddTeamEr;
    @FXML
    private Button backudd;

    @FXML
    private TextField uddAge;

    @FXML
    private TextField uddCar;

    @FXML
    private TextField uddName;
    @FXML
    private TextField uddTeam;

    @FXML
    private TextField uddPoints;

    @FXML
    private TextField uddtext;

    @FXML
    private Button uddSearch;
    @FXML
    private Button uddUpdate;

    AddController addController = new AddController();

    public void searchDriver(){
        String udName = uddtext.getText().toUpperCase();
        for(int i=0;i<addController.driverlist.size();i++){
            if (udName.equals(addController.driverlist.get(i).name)){
                uddName.setText(addController.driverlist.get(i).name);
                uddAge.setText(String.valueOf(addController.driverlist.get(i).age));
                uddCar.setText(addController.driverlist.get(i).car);
                uddPoints.setText(String.valueOf(addController.driverlist.get(i).points));
                uddTeam.setText(addController.driverlist.get(i).team);

                addController.driverlist.remove(i);
            }
        }
        uddtext.clear();
    }

    public void updateDriver(){
        String name = uddName.getText().toUpperCase();
        String age = uddAge.getText();
        String car = uddCar.getText();
        String points = uddPoints.getText();
        String team = uddTeam.getText();

        if (addController.addName(name,uddNameEr) && addController.addAge(age, uddAgeEr) && addController.addCar(car,uddCarEr) && addController.addPoints(points,uddPointsEr) && addController.addTeam(team,uddTeamEr)) {
            uddNameEr.setText("");
            uddAgeEr.setText("");
            uddCarEr.setText("");
            uddTeamEr.setText("");
            uddPointsEr.setText("");
            Driver driver = new Driver(name,Integer.parseInt(age),team,car,Integer.parseInt(points));
            addController.driverlist.add(driver);

            uddName.clear();
            uddAge.clear();
            uddPoints.clear();
            uddTeam.clear();
            uddCar.clear();
        }
    }

    public void setBackUDD(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();

    }

}
