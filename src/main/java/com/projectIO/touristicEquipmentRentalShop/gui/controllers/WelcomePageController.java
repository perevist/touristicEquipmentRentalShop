package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private GridPane rootPane;
    @FXML
    private Button loginButton;
    @FXML
    private Button registrationButton;

    @FXML
    void loadLoginForm(ActionEvent event) throws IOException {
        SceneChanger.changeScene(rootPane, getClass(), "/fxml/loginForm.fxml");
    }

    @FXML
    void loadRegistrationForm(ActionEvent event) throws IOException {
        SceneChanger.changeScene(rootPane, getClass(), "/fxml/registrationForm.fxml");
    }
}