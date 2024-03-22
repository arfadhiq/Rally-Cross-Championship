package com.example.cwfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    @FXML
    private Label mainMsg;
    AddController addController = new AddController();


    public void swichToAdd(ActionEvent actionEvent) throws IOException {
        mainMsg.setText(" ");
        Stage stage= new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
    }

    public void switchToDDD(ActionEvent actionEvent) throws IOException {
        mainMsg.setText(" ");
        Stage stage2= new Stage();
        Parent root2= FXMLLoader.load(getClass().getResource("delete.fxml"));
        Scene scene2=new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
    }
    public void switchToUDD(ActionEvent actionEvent) throws IOException {
        mainMsg.setText(" ");
        Stage stage2= new Stage();
        Parent root2= FXMLLoader.load(getClass().getResource("udd.fxml"));
        Scene scene2=new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
    }


    public void switchToVCT(ActionEvent actionEvent) throws IOException {
        mainMsg.setText(" ");
        Stage stage2= new Stage();
        Parent root2= FXMLLoader.load(getClass().getResource("vct.fxml"));
        Scene scene2=new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
    }

    public void switchToSRR(ActionEvent actionEvent) throws IOException {
        mainMsg.setText(" ");
        Stage stage3= new Stage();
        Parent root3= FXMLLoader.load(getClass().getResource("srr.fxml"));
        Scene scene2=new Scene(root3);
        stage3.setScene(scene2);
        stage3.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
    }

    public void saveCurrentData(){
        System.out.println(addController.driverlist.get(0).name);
                try {
            FileWriter writer = new FileWriter("drivers.txt",true);
            for (int i=0; i<addController.driverlist.size();i++){
                writer.write(addController.driverlist.get(i).name +" ");
                writer.write(addController.driverlist.get(i).age +" ");
                writer.write(addController.driverlist.get(i).team +" ");
                writer.write(addController.driverlist.get(i).car +" ");
                writer.write(addController.driverlist.get(i).points +"\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println("An error occured while writing");
            System.out.println(e.getMessage());
        }
        mainMsg.setText(" Driver details saved successfully");

    }

    public void loadCurrentData(){
        try {
            File myObj = new File("drivers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split(" ");
                boolean exist = false;
                for (Driver driver : addController.driverlist) {
                    if (driver.name.equals(line[0])) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    addController.driverlist.add(new Driver(line[0],Integer.parseInt(line[1]),line[2],line[3],Integer.parseInt(line[4])));
                }
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An Error Occurred!");
        }
        mainMsg.setText("Driver details loaded successfully");
    }

    public void exit(){
        System.exit(0);
    }
}
