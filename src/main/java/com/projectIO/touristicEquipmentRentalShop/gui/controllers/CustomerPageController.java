package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

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
        UserInSystem.getInstance().setUserType(UserType.GUEST);
        ScreenManager.getInstance().activate("welcomePage");
    }

    @FXML
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/customerPageImg.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @FXML
    public void initialize(){
        rootPane.setBackground(new Background(myBI));
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
