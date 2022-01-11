package controller;

import Data.Create;
import Data.ParkVehicleBtn;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CreateAccountDataFormController {
    public AnchorPane createAccountPane;
    public PasswordField txtPassword;
    public PasswordField txtConfirm;
    public TextField txtEmail;
    public TextField txtLast;
    public JFXButton btnLogin;
    public JFXButton btnBack;
    public JFXButton btnCreate;
    public TextField txtFirst;
    AnchorPane closePane;

    static ArrayList<Create> DataList = new ArrayList();

    public void moveToConfirm(ActionEvent actionEvent) {
        txtConfirm.requestFocus();
    }

    public void moveToLast(ActionEvent actionEvent) {
        txtLast.requestFocus();
    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void moveToEmail(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void loginForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriversSystemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) createAccountPane.getScene().getWindow();
        window.setScene(new Scene(load));
        toClose();

    }
    public void setPane(AnchorPane pane){

        closePane=pane;
    }
    public void toClose(){
        Stage stage = (Stage) closePane.getScene().getWindow();
        stage.close();
    }

    public void createDataSaveMethod(ActionEvent actionEvent) {
        Create create = new Create(txtFirst.getText(),txtLast.getText(),txtEmail.getText(),txtPassword.getText(),txtConfirm.getText());
        txtFirst.clear();
        txtLast.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtConfirm.clear();

        if (DataList.add(create)) {

            new Alert(Alert.AlertType.CONFIRMATION, "Successfully......", ButtonType.CLOSE).show();
        } else {

            new Alert(Alert.AlertType.WARNING, "Try Again.......", ButtonType.CLOSE).show();
        }
    }

}
