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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class SrrController implements Initializable {


    @FXML
    private Label srrCiity;

    @FXML
    private Label srrDate;
    @FXML
    private Button startRace;
    @FXML
    private TableColumn<Driver, Integer> srrAge;

    @FXML
    private TableColumn<Driver, String> srrCar;

    @FXML
    private TableColumn<Driver, String> srrName;

    @FXML
    private TableColumn<Driver, Integer> srrPoints;

    @FXML
    private TableView<Driver> srrTable;

    @FXML
    private TableColumn<Driver, String> srrTeam;



    AddController addController= new AddController();
    int n= addController.driverlist.size();

    String[] drivers = new String[n];
    ObservableList<Driver> myList3 = FXCollections.observableArrayList();
    ArrayList<Race> racelist = new ArrayList<>();

    public void random_race(){
        List<String> places = new ArrayList<String>(Arrays.asList("Barcelona", "Nyirád", "Höljes", "Montalegre", "Rīga", "Norway"));
        Random rand = new Random();
        String location = places.get(rand.nextInt(places.size()));
        System.out.println(location);

        LocalDateTime start_d = LocalDateTime.of(2015, Month.MAY, 30, 0, 0);
        LocalDateTime end_d = LocalDateTime.now();
        long daysBetween = ChronoUnit.DAYS.between(start_d, end_d);
        LocalDateTime random_date = start_d.plusDays(rand.nextInt((int) daysBetween + 1));
        String date1 = random_date.toLocalDate().toString();
        System.out.println(date1);

        Collections.shuffle(addController.driverlist);

        for (int i=0; i<n;i++){
            drivers[i] = addController.driverlist.get(i).name;
        }

        Race race = new Race(date1,location,drivers);
        racelist.add(race);

        srrCiity.setText(location);
        srrDate.setText(date1);


        try {
            FileWriter writer = new FileWriter("races.txt",true);
            writer.write(race.date1 +" ");
            writer.write(race.location +" ");
            for (String line :drivers)
                writer.write(line +" ");
            writer.write("\n");
            writer.close();


        }catch (IOException e){
            System.out.println("An error occurred while writing");
            System.out.println(e.getMessage());
        }


        for(int j=0;j <drivers.length;j++){
            for(int k=0;k <drivers.length;k++){
                if (j==0 && drivers[j].equals(addController.driverlist.get(k).name)){
                    addController.driverlist.get(k).points=addController.driverlist.get(k).points+10;
                }
                if (j==1 && drivers[j].equals(addController.driverlist.get(k).name)){
                    addController.driverlist.get(k).points=addController.driverlist.get(k).points+7;
                }
                if (j==2 && drivers[j].equals(addController.driverlist.get(k).name)){
                    addController.driverlist.get(k).points=addController.driverlist.get(k).points+5;
                }


            }

        }

        myList3.addAll(addController.driverlist);
        startRace.setVisible(false);


        System.out.println();
        System.out.println();
        for (int i=0;i <racelist.size();i++){
            System.out.println(racelist.get(i).date1);
            System.out.println(racelist.get(i).location);
            for (int j=0;j <racelist.get(i).drivers.length;j++){
                System.out.println(racelist.get(i).drivers[j]);
            }
            System.out.println();

        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        srrName.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        srrAge.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("age"));
        srrCar.setCellValueFactory(new PropertyValueFactory<Driver,String>("car"));
        srrPoints.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("points"));
        srrTeam.setCellValueFactory(new PropertyValueFactory<Driver,String>("team"));
        srrTable.setItems(myList3);

    }

    public void setBackSRR(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
        // MainController stage2=new MainController();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage prevStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();


    }
}
