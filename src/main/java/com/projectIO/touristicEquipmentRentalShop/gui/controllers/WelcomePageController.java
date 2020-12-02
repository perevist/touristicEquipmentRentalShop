package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

public class WelcomePageController implements MainController {

    @FXML
    private GridPane rootPane;
    @FXML
    private Button loginButton;
    @FXML
    private Button registrationButton;
    @FXML
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/welcomePageImg2.png",1185,
            775,false,true), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    @Override
    public void updateDataInView() {

    }

    @FXML
    void loadLoginForm(ActionEvent event){
        ScreenManager.getInstance().activate("loginForm");
    }

    @FXML
    void loadRegistrationForm(ActionEvent event){
        ScreenManager.getInstance().activate("registrationForm");
    }

    @FXML
    public void initialize(){
        rootPane.setBackground(new Background(myBI));
    }


    public void printMessage() {
        System.out.println("Siemano");
    }
}