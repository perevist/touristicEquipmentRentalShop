package com.projectIO.touristicEquipmentRentalShop.application;

import com.projectIO.touristicEquipmentRentalShop.dao.EntityManagerProvider;
import com.projectIO.touristicEquipmentRentalShop.gui.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.gui.controllers.WelcomePageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGuiApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initializeConnectionWithDb();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));
//        initializeScreens();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/welcomePage.fxml"));
//        Parent root = loader.load();
//        WelcomePageController controller = loader.getController();
//        controller.printMessage();

        stage.setTitle("Wypożyczania sprzętu turystycznego");
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setScene(new Scene(root, 800, 500));
//        stage.setScene(ScreenManager.getInstance().getMainScene());
        stage.show();
    }

    private void initializeScreens() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));
        Scene mainScene = new Scene(root, 800, 500);
        ScreenManager.getInstance().setMainScene(mainScene);

        ScreenManager.getInstance().addScreen("administratorPage",
                FXMLLoader.load(getClass().getResource("/fxml/administratorPage.fxml")));
        ScreenManager.getInstance().addScreen("customerPage",
                FXMLLoader.load(getClass().getResource("/fxml/customerPage.fxml")));
        ScreenManager.getInstance().addScreen("employeePage",
                FXMLLoader.load(getClass().getResource("/fxml/employeePage.fxml")));
        ScreenManager.getInstance().addScreen("loginForm",
                FXMLLoader.load(getClass().getResource("/fxml/loginForm.fxml")));
        ScreenManager.getInstance().addScreen("makeReservationPage",
                FXMLLoader.load(getClass().getResource("/fxml/makeReservationPage.fxml")));
        ScreenManager.getInstance().addScreen("registrationForm",
                FXMLLoader.load(getClass().getResource("/fxml/registrationForm.fxml")));
        ScreenManager.getInstance().addScreen("reservationDetailsPage",
                FXMLLoader.load(getClass().getResource("/fxml/reservationDetailsPage.fxml")));
        ScreenManager.getInstance().addScreen("welcomePage",
                FXMLLoader.load(getClass().getResource("/fxml/welcomePage")));
    }

    private void initializeConnectionWithDb() {
        EntityManagerProvider.getInstance();
    }
}
