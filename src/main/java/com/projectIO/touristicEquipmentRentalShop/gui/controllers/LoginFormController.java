package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectPasswordException;
import com.projectIO.touristicEquipmentRentalShop.gui.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.LoginServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.LoginService;
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

    private LoginService loginService;

    public LoginFormController() {
        loginService = new LoginServiceImpl();
    }

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
        String userTypeName = choiceBox.getValue();

        UserType[] userTypes = UserType.values();
        UserType userType = null;

        for (UserType us : userTypes) {
            if(us.getName().equals(userTypeName))
                userType = us;
        }

        try {
            loginService.loginUser(login, password, userType);
        }catch (IncorrectLoginException | IncorrectPasswordException exception) {
            String message = exception.getMessage();
            AlertWindow.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION, window, "Błąd", message);
            return;
        }

        AlertWindow.showAlert(Alert.AlertType.CONFIRMATION, window, "Pomyślne logowanie",
                "Zalogowano do systemu");

        Stage stage = (Stage) window;
        Parent pane = null;

        switch (userType) {
            case CUSTOMER:
                pane = FXMLLoader.load(getClass().getResource("/fxml/customerPage.fxml"));
                break;
            case EMPLOYEE:
                pane = FXMLLoader.load(getClass().getResource("/fxml/employeePage.fxml"));
                break;
            case ADMINISTRATOR:
                break;
        }
        stage.setScene(new Scene(pane, 800, 500));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserType[] userTypes = UserType.values();
        List<String> options = new ArrayList<>();

        for (int i = 1; i < userTypes.length; i++) {
            options.add(userTypes[i].getName());
        }

        choiceBox.getItems().setAll(options);
    }

    private boolean checkAreAllFieldsFilledIn() {
        if(loginField.getText().isEmpty() || passwordField.getText().isEmpty() || choiceBox.getValue() == null)
            return false;
        else
            return true;
    }
}