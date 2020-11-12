package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerPageController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button makeReservationButton;

    @FXML
    private Button showReservationsButton;

    @FXML
    private Button logOutButton;

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void makeReservation(ActionEvent event) throws IOException {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        Parent pane = FXMLLoader.load(getClass().getResource("/fxml/makeReservationPage.fxml"));
        stage.setScene(new Scene(pane, 900, 500));
    }

    @FXML
    void showReservations(ActionEvent event) {

    }

}
