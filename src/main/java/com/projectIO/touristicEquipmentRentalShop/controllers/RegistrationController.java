package com.projectIO.touristicEquipmentRentalShop.controllers;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.event.ActionEvent;

public class RegistrationController {

    private RentalShopApp rentalShopApp = new RentalShopApp();

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
    public void register(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String login = loginField.getText();
        String password = passwordField.getText();

        rentalShopApp.registerCustomerInSystem(login, firstName, lastName, phoneNumber, email ,password);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + firstNameField.getText());

    }


    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
