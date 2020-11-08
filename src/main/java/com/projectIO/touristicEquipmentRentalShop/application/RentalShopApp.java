package com.projectIO.touristicEquipmentRentalShop.application;

import com.projectIO.touristicEquipmentRentalShop.services.RegistrationService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RentalShopApp extends Application {

    private RegistrationService registrationService;

    public RentalShopApp() {
        registrationService = new RegistrationService();
    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));
        stage.setTitle("Wypożyczania sprzętu turystycznego");
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void registerCustomerInSystem(String login, String firstName, String lastName, String phoneNumber,
                                         String email, String password) {

        registrationService.registerCustomer(login, firstName, lastName, phoneNumber, email, password);
    }
}
