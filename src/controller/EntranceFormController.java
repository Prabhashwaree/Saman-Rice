package controller;

import Data.Create;
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

public class EntranceFormController {
    public AnchorPane enterFormPane;
    public TextField txtName;
    public JFXButton btnLogin;
    public JFXButton btnAccount;
    public PasswordField txtPassword;
    public JFXButton btnSave;
    private String name;
    private String password;

    static ArrayList<EntranceFormController> DataList = new ArrayList();

    public EntranceFormController() {
    }

    public EntranceFormController(String name, String password) {
        this.name = name;
        this.password = password;
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

    public void accountForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CreateAccountDataForm.fxml"));
        Parent load = fxmlLoader.load();
        CreateAccountDataFormController createAccountDataFormController= fxmlLoader.getController();
        createAccountDataFormController.setPane(enterFormPane);
        Scene scene = new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void loginForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriversSystemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) enterFormPane.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void saveMethod(ActionEvent actionEvent) {
        EntranceFormController save = new EntranceFormController(txtName.getText(),txtPassword.getText());
        txtName.clear();
        txtPassword.clear();
        if (DataList.add(save)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully......", ButtonType.CLOSE).show();
        } else {

            new Alert(Alert.AlertType.WARNING, "Try Again.......", ButtonType.CLOSE).show();
        }
    }
}
