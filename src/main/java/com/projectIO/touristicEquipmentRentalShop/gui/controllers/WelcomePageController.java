package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class WelcomePageController implements MainController {

    @FXML
    private GridPane rootPane;
    @FXML
    private Button loginButton;
    @FXML
    private Button registrationButton;

    @Override
    public void updateDataInView() {

    }

    @FXML
    void loadLoginForm(ActionEvent event) throws IOException {
        ScreenManager.getInstance().activate("loginForm");
    }

    @FXML
    void loadRegistrationForm(ActionEvent event) throws IOException {
        ScreenManager.getInstance().activate("registrationForm");
    }

    public void printMessage() {
        System.out.println("Siemano");
    }
}