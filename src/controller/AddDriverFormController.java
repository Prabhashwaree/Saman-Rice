package controller;

import Data.AddDriver;
import Data.AddVehicle;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class AddDriverFormController {
    public AnchorPane addDriversPane;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtLicenseNo;
    public TextField txtNIC;
    public JFXButton btnAddDriver;

    static ArrayList<AddDriver> DriverList = new ArrayList();

    public void moveToNIC(ActionEvent actionEvent) {
        txtNIC.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }
    public void moveToContact(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }
    public void moveToLicenseNo(ActionEvent actionEvent) {
        txtLicenseNo.requestFocus();
    }

    public void addDriverBtnMethod(ActionEvent actionEvent) {
        AddDriver addDriver = new AddDriver(txtName.getText(),txtNIC.getText(),txtLicenseNo.getText(),txtContact.getText(),txtAddress.getText());
        txtName.clear();
        txtNIC.clear();
        txtLicenseNo.clear();
        txtContact.clear();
        txtAddress.clear();

        if (DriverList.add(addDriver)) {

            new Alert(Alert.AlertType.CONFIRMATION, "Add Driver is Successfully......", ButtonType.CLOSE).show();
        } else {

            new Alert(Alert.AlertType.WARNING, "Try Again....", ButtonType.CLOSE).show();
        }
    }



}
