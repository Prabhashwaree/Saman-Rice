package controller;

import Data.AddVehicle;
import Data.ParkVehicleBtn;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class AddVehicleFormController {

    public AnchorPane addVehiclePane;
    public TextField txtNumber;
    public TextField txtPassengers;
    public TextField txtWeight;
    public TextField txtType;
    public ComboBox cmbDetail;
    public JFXButton btnAddVehicle;

    static ArrayList<AddVehicle> VehicleList = new ArrayList();

    public void initialize(){
        cmbDetail.getItems().addAll(
                "Bus",
                "Van",
                "Cargo Lorry"
        );
    }

    public void moveToPassengers(ActionEvent actionEvent) {
        txtPassengers.requestFocus();
    }

    public void moveToWeight(ActionEvent actionEvent) {
        txtWeight.requestFocus();
    }

    public void detailCmbMethod(ActionEvent actionEvent) {

    }

    public void btnAddVehicleMethod(ActionEvent actionEvent) {
        AddVehicle addVehicles = new AddVehicle(txtNumber.getText(),txtWeight.getText(),txtPassengers.getText(),cmbDetail.getSelectionModel().getSelectedItem().toString());
        txtNumber.clear();
        txtWeight.clear();
        txtPassengers.clear();

        if (VehicleList.add(addVehicles)) {

            new Alert(Alert.AlertType.CONFIRMATION, "Add Vehicle is Successfully..", ButtonType.CLOSE).show();
        } else {

            new Alert(Alert.AlertType.WARNING, "Try Again Your Adding Vehicle..", ButtonType.CLOSE).show();
        }
    }

}
