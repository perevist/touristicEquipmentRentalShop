package com.projectIO.touristicEquipmentRentalShop.controllers;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectPasswordException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    private RentalShopApp rentalShopApp = new RentalShopApp();

    @FXML
    private GridPane rootPane;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML

    void login(ActionEvent event) throws IOException {
        Window window = submitButton.getScene().getWindow();

        if(!checkAreAllFieldsFilledIn()) {
            AlertWindow.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION, window, "Błąd",
                    "Proszę uzupełnić wszystkie pola");
            return;
        }

        String login = loginField.getText();
        String password = passwordField.getText();
        String userType = choiceBox.getValue();

        try {
            rentalShopApp.loginUserInSystem(login, password, userType);
        }catch (IncorrectLoginException | IncorrectPasswordException exception) {
            String message = exception.getMessage();
            AlertWindow.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION, window, "Błąd", message);
            return;
        }

        AlertWindow.showAlert(Alert.AlertType.CONFIRMATION, window, "Pomyślne logowanie",
                "Zalogowano do systemu");

        Stage stage = (Stage) window;
        Parent pane = FXMLLoader.load(getClass().getResource("/fxml/customerPage.fxml"));
        stage.setScene(new Scene(pane, 800, 500));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> options = new ArrayList<>();
        options.add("Klient");
        options.add("Pracownik");
        choiceBox.getItems().setAll(options);
    }

    private boolean checkAreAllFieldsFilledIn() {

        if(loginField.getText().isEmpty() || passwordField.getText().isEmpty() || choiceBox.getValue() == null)
            return false;
        else
            return true;
    }
}