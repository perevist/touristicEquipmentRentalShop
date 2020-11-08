package com.projectIO.touristicEquipmentRentalShop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private GridPane rootPane;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    @FXML
    void loadLoginForm(ActionEvent event) {


    }

    @FXML
    void loadRegistrationForm(ActionEvent event) throws IOException {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        Parent pane = FXMLLoader.load(getClass().getResource("/fxml/registrationForm.fxml"));
        stage.setScene(new Scene(pane, 800, 500));
    }
}