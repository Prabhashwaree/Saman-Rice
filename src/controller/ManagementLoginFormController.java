package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginFormController {
    public AnchorPane managementLoginPane;
    public TextField txtName;
    public TextField txtPassword;
    public JFXButton btnLogin;
    AnchorPane closePane;
    private String name;
    private String password;

    public ManagementLoginFormController() {
    }

    public ManagementLoginFormController(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    public void moveToPassword(ActionEvent actionEvent) {
            txtPassword.requestFocus();


    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        if(txtName.getText().equals("nethmini")&&txtPassword.getText().equals("admin@123")){
            txtName.clear();
            txtPassword.clear();
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully......", ButtonType.CLOSE).show();
            URL resource = getClass().getResource("../view/ManagementTableForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) managementLoginPane.getScene().getWindow();
            window.setScene(new Scene(load));
            toClose();

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again.......", ButtonType.CLOSE).show();
        }
    }
    public void setPane(AnchorPane pane){

        closePane=pane;
    }
    public void toClose(){
        Stage stage = (Stage) closePane.getScene().getWindow();
        stage.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void passwordMethod(ActionEvent actionEvent) {

    }
}
