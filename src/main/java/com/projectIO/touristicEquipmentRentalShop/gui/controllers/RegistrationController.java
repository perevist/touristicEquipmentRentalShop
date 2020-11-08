package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.gui.AlertWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.ActionEvent;

import java.io.IOException;

public class RegistrationController {

    private RentalShopApp rentalShopApp = new RentalShopApp();

    @FXML
    private GridPane rootPane;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button submitButton;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField loginField;

    @FXML

    public void register(ActionEvent event) throws IOException {

        Window window = submitButton.getScene().getWindow();

        if (checkAreAllFieldsFilledIn() == false) {
            AlertWindow.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION, window, "Błąd",
                    "Proszę uzupełnić wszystkie pola");
            return;
        }

        String login = loginField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        try {
            rentalShopApp.registerCustomerInSystem(login, firstName, lastName, phoneNumber, email, password);
        } catch (IncorrectLoginException exception) {
            String message = exception.getMessage();
            AlertWindow.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION, window, "Błąd", message);
            return;
        }

        AlertWindow.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION, window, "Rejestracja wykonana",
                "Rejestracja przebiegła pomyślnie");

        Stage stage = (Stage) window;
        Parent pane = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));
        stage.setScene(new Scene(pane, 800, 500));
    }

    private boolean checkAreAllFieldsFilledIn() {
        if (loginField.getText().isEmpty() || firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty()
                || phoneNumberField.getText().isEmpty() || emailField.getText().isEmpty()
                || passwordField.getText().isEmpty()) {

            return false;
        } else
            return true;
    }
}
