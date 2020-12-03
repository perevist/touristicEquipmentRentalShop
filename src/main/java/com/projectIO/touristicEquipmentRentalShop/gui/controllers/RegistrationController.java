package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.RegistrationServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.RegistrationService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;

import java.io.IOException;

public class RegistrationController implements MainController {

    private RegistrationService registrationService;

    public RegistrationController() {
        registrationService = new RegistrationServiceImpl();
    }

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
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/registerPageImg.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void updateDataInView() {
        firstNameField.clear();
        emailField.clear();
        passwordField.clear();
        lastNameField.clear();
        phoneNumberField.clear();
        loginField.clear();
    }

    @FXML
    public void initialize(){
        rootPane.setBackground(new Background(myBI));
    }
    @FXML
    void backToWelcomePage(ActionEvent event) {
        ScreenManager.getInstance().activate("welcomePage");
    }
    @FXML
    public void register(ActionEvent event) throws IOException {
        if (checkAreAllFieldsFilledIn() == false) {
            AlertWindow.showAlert(rootPane, "Błąd", "Proszę uzupełnić wszystkie pola");
            return;
        }

        try {
            loadDataFromFormAndRegisterUser();
        } catch (IncorrectLoginException exception) {
            AlertWindow.showAlert(rootPane, "Błąd", exception.getMessage());
            return;
        }

        AlertWindow.showAlert(rootPane, "Rejestracja wykonana", "Rejestracja przebiegła pomyślnie");
        ScreenManager.getInstance().activate("welcomePage");
    }

    private void loadDataFromFormAndRegisterUser() {
        String login = loginField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        registrationService.registerCustomer(login, firstName, lastName, phoneNumber, email, password);
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
