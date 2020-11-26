package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CustomerPageController implements MainController {

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
        ScreenManager.getInstance().activate("welcomePage");
    }

    @FXML
    void makeReservation(ActionEvent event) throws IOException {
        ScreenManager.getInstance().activate("makeReservationPage");
    }

    @FXML
    void showReservations(ActionEvent event) throws IOException {
        ScreenManager.getInstance().activate("reservationDetailsPage");
    }

    @Override
    public void updateDataInView() {
    }
}
