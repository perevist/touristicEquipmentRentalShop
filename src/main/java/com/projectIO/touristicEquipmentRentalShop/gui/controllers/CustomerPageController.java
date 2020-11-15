package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

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
    void logOut(ActionEvent event) throws IOException {
        SceneChanger.changeScene(rootPane, getClass(), "/fxml/welcomePage.fxml");
    }

    @FXML
    void makeReservation(ActionEvent event) throws IOException {
        SceneChanger.changeScene(rootPane, getClass(), "/fxml/makeReservationPage.fxml");
    }

    @FXML
    void showReservations(ActionEvent event) throws IOException {
        SceneChanger.changeScene(rootPane, getClass(), "/fxml/reservationDetailsPage.fxml");
    }

}
