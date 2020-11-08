package com.projectIO.touristicEquipmentRentalShop.application;

import com.projectIO.touristicEquipmentRentalShop.services.LoginService;
import com.projectIO.touristicEquipmentRentalShop.services.RegistrationService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RentalShopApp extends Application {

    private static RentalShopApp instance;

    private RegistrationService registrationService;
    private LoginService loginService;

    public static void main(String[] args) {
        launch(args);
    }

    public RentalShopApp() {
        registrationService = new RegistrationService();
        loginService = new LoginService();
    }

    public static RentalShopApp getInstance() {
        if (instance == null) {
            instance = new RentalShopApp();
        }
        return instance;
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

    public void loginUserInSystem(String login, String password, String userType) {
        loginService.loginUser(login, password, userType);
    }
}
