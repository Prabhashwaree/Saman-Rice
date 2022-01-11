package controller;

import Data.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tm.OnDeliveryTM;
import tm.ParkVehicleBtnTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DriversSystemFormController {
    public ComboBox cmbNumber;
    public JFXTextField txtSlot;
    public ComboBox cmbDriver;
    public JFXButton btnPark;
    public JFXButton btnShift;
    public JFXTextField txtType;
    public JFXTextField txtTime;
    public JFXTextField txtDate;
    public JFXButton btnLogin;
    public AnchorPane driverPane;
    public VanForm van = new VanForm();
    public LorryForm lorry = new LorryForm();

    static ArrayList<ParkVehicleBtn> ParkList = new ArrayList();
    static ArrayList<OnDelivery> DeliveryList = new ArrayList();
    public JFXButton btnBack;

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            txtTime.setText(LocalDateTime.now().format(formatter1));
            txtDate.setText(LocalDateTime.now().format(formatter2));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    public void initialize(){
                initClock();
        cmbNumber.getItems().addAll("NA-3434", "KA-4563", "58-3567", "GF-4358", "CCB-3568", "LM-6679", "QA-3369", "KB-3668", "JJ-9878", "GH-5772", "XY-4456", "YQ-3536", "CBB-3566", "QH-3444");
        cmbDriver.getItems().addAll("Sumith Kumara", "Amila Pathirana", "Jithmal Perera", "Sumith Dissanayaka", "Sumanasiri Herath", "Awantha Fernando", "Charith Sudara ", "Prashan Dineth", "Chethiya Dilan", "Dushantha Perera", "Sumith Udayanga", "Dinesh Udara", "Udana Chathuranga", "Mohommad Riaz", "Sandun Kumara", "Priyanga Perera");

        cmbNumber.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue=="NA-3434") {
                BusForm bus = new BusForm(newValue);
                bus.Park();
                txtType.setText(bus.busType);
                txtSlot.setText(bus.busTemp);

            }else {
                if (newValue.equals("KA-4563") || newValue.equals("58-3567") || newValue.equals("GF-4358") || newValue.equals("CCB-3568") || newValue.equals("LM-6679") || newValue.equals("QA-3369")) {
                    van.park();
                    txtType.setText(van.vanType);
                    for (int i = 0; i < van.vanTemp.length; i++) {
                        if (van.vanTemp[i] != "") {
                            txtSlot.setText(van.vanTemp[i]);
                            van.vanTemp[i] = "";
                            break;
                    }
                }


                }else {
                    if(newValue.equals("KB-3668")||newValue.equals("JJ-9878")||newValue.equals("GH-5772")||newValue.equals( "XY-4456")|newValue.equals("YQ-3536")||newValue.equals("CBB-3566")||newValue.equals( "QH-3444")) {
                        lorry.park();
                        txtType.setText(lorry.lorryType);
                        for (int i = 0; i < lorry.lorryTemp.length; i++) {
                            if (lorry.lorryTemp[i] != "") {
                                txtSlot.setText(lorry.lorryTemp[i]);
                                lorry.lorryTemp[i] = "";
                                break;
                            }
                        }
                }
            }

            }

        });
    }

    public void comboVehicleNumber(ActionEvent actionEvent) {

    }

    public void textSlot(ActionEvent actionEvent) {
    }

    public void comboDriver(ActionEvent actionEvent) {
    }

    public void parkVehicleBtn(ActionEvent actionEvent) {
        ParkVehicleBtn Park = new ParkVehicleBtn(cmbNumber.getSelectionModel().getSelectedItem().toString(),txtType.getText(),txtSlot.getText(),txtTime.getText(),txtDate.getText());
        txtType.clear();
        txtSlot.clear();
        txtTime.clear();
        txtDate.clear();

        if (ParkList.add(Park)) {

           loadAlParkVehicleBtn();
            new Alert(Alert.AlertType.CONFIRMATION, "Parking Successfully..", ButtonType.CLOSE).show();
        } else {

            new Alert(Alert.AlertType.WARNING, "Try Again Your parking..", ButtonType.CLOSE).show();
        }
    }

    private void loadAlParkVehicleBtn() {
        ObservableList<ParkVehicleBtnTM> tmObservableList = FXCollections.observableArrayList();
        for (ParkVehicleBtn temp : ParkList) {
            tmObservableList.add(new ParkVehicleBtnTM(temp.getNumber(), temp.getType(), temp.getSlot(), temp.getTime(), temp.getDate()));

        }

    }
    public void DeliveryShiftBtn(ActionEvent actionEvent) {
        OnDelivery Delivery = new  OnDelivery(cmbNumber.getSelectionModel().getSelectedItem().toString(),txtType.getText(),cmbDriver.getSelectionModel().getSelectedItem().toString(),txtTime.getText(),txtDate.getText());
        txtType.clear();
        txtTime.clear();
        txtDate.clear();

        if (DeliveryList.add(Delivery)) {

            loadAlDeliveryShiftBtn();
            new Alert(Alert.AlertType.CONFIRMATION, "On Delivery Shift is Successfully..", ButtonType.CLOSE).show();
        } else {

            new Alert(Alert.AlertType.WARNING, "Try Again Your On Delivery Shift..", ButtonType.CLOSE).show();
        }

    }
    private void loadAlDeliveryShiftBtn() {
        ObservableList<OnDeliveryTM> tmObservableList = FXCollections.observableArrayList();
        for (OnDelivery temp : DeliveryList) {
            tmObservableList.add(new ParkVehicleBtnTM(temp.getNumbers(), temp.getTypes(), temp.getNames(), temp.getTimes(), temp.getDates()));

        }

    }

    public void managementLoginBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ManagementLoginForm.fxml"));
        Parent load = fxmlLoader.load();
        ManagementLoginFormController managementLoginFormController = fxmlLoader.getController();
        managementLoginFormController.setPane(driverPane);
        Scene scene = new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void dateText(ActionEvent actionEvent) {
    }



    public void timeText(ActionEvent actionEvent) {

    }
    public void textVehicleType(ActionEvent actionEvent) {
    }

    public void backToWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EntranceForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) driverPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
