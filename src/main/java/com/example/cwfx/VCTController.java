package com.example.cwfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class VCTController implements Initializable {

    @FXML
    private TableColumn<Driver, Integer> agecol;

    @FXML
    private TableColumn<Driver, String> carcol;

    @FXML
    private TableColumn<Driver, String> namecol;

    @FXML
    private TableColumn<Driver, Integer> pointscol;

    @FXML
    private TableColumn<Driver, String> teamcol;

    @FXML
    private TableView<Driver> vcttable;


    private ObservableList<Driver> driverList;


//    public void setDriverList(ObservableList<Driver> driverList) {
//        this.driverList = driverList;
//    }




    public void setBacknew(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();


    }
    AddController addController=new AddController();

    public ObservableList<Driver> myList2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        namecol.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        agecol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("age"));
        carcol.setCellValueFactory(new PropertyValueFactory<Driver,String>("car"));
        pointscol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("points"));
        teamcol.setCellValueFactory(new PropertyValueFactory<Driver,String>("team"));

        insertionSort(addController.driverlist);

        myList2.addAll(addController.driverlist);
        vcttable.setItems(myList2);
    }




    void insertionSort(ArrayList<Driver> arr) {
        int n = arr.size();
        for(int i=1;i<n;i++) {
            Driver key = arr.get(i);
            int j= i-1;
            int keyPoints= key.points;
            int jPoints = arr.get(j).points;

            while(j>=0 && jPoints<keyPoints) {
                arr.set(j+1,arr.get(j));
                //arr.get(j+1)=arr.get(j);
                j=j-1;
                if (j>=0) {
                    jPoints = arr.get(j).points;
                }
            }
            arr.set(j+1,key);
        }
    }


}
