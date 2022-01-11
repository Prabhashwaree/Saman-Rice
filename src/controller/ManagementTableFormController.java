package controller;

import Data.OnDelivery;
import Data.ParkVehicleBtn;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tm.ParkVehicleBtnTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ManagementTableFormController<combo, box> {

    public AnchorPane managementTablePane;
    public ComboBox cmbTables;
    public JFXButton btnAddVehicle;
    public JFXButton btnAddDriver;
    public JFXButton btnLogOut;
    public TableView tblInParking;
    public TableColumn colNumber;
    public TableColumn colType;
    public TableColumn colSlot;
    public TableColumn colTime;
    public TableColumn colDate;
    public TableView tblOnDelivery;


    static ArrayList<ParkVehicleBtn> ParkList = new ArrayList();
    public TableColumn colNumbers;
    public TableColumn colTypes;
    public TableColumn colNames;
    public TableColumn colTimes;
    public TableColumn colDates;

    static ArrayList<OnDelivery> DeliveryList = new ArrayList();

    public void initialize(){
        cmbTables.getItems().addAll(
                "In Parking",
                "On Delivery"


        );
        cmbTables.setValue("On Delivery");

        tblInParking.setItems(FXCollections.observableArrayList(DriversSystemFormController.ParkList));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colSlot.setCellValueFactory(new PropertyValueFactory<>("slot"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        cmbTables.setValue("InParking");

        tblOnDelivery.setItems(FXCollections.observableArrayList(DriversSystemFormController.DeliveryList));
        colNumbers.setCellValueFactory(new PropertyValueFactory<>("numbers"));
        colTypes.setCellValueFactory(new PropertyValueFactory<>("types"));
        colNames.setCellValueFactory(new PropertyValueFactory<>("names"));
        colTimes.setCellValueFactory(new PropertyValueFactory<>("times"));
        colDates.setCellValueFactory(new PropertyValueFactory<>("dates"));
    }

    public void cmbTableWindow(ActionEvent actionEvent) {
        if(cmbTables.getValue().equals("In Parking")){
            tblOnDelivery.setVisible(false);
            tblInParking.setVisible(true);


        }else{
            tblInParking.setVisible(false);
            tblOnDelivery.setVisible(true);

        }

    }

    public void btnAddVehicleForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void btnAddDriverForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void btnLogOutBackToHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriversSystemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) managementTablePane.getScene().getWindow();
        window.setScene(new Scene(load));
    }


}
