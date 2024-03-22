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
import java.util.Scanner;

public class DeleteController {
    @FXML
    private Label delMsg;

    @FXML
    private Button deletebtn;

    @FXML
    private TextField namedlt;

    AddController addController = new AddController();

    MainController main = new MainController();
   public void deleteDriver(){

       String name = namedlt.getText().toUpperCase();

       for (int i=0;i<addController.driverlist.size();i++){
           if (name.equals(addController.driverlist.get(i).name)) {
               delMsg.setText("Driver Found and Deleted successfully");
               addController.driverlist.remove(i);
           }else
               delMsg.setText("Name Not Found");
       }
       namedlt.clear();
    }


    public void setBackDdd(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();

    }
}
