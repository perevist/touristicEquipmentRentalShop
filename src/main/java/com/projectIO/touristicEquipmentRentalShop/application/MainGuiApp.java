package com.projectIO.touristicEquipmentRentalShop.application;

import com.projectIO.touristicEquipmentRentalShop.dao.EntityManagerProvider;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.AppScreen;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGuiApp extends Application {

    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        initializeConnectionWithDb();
        initializeScreens();

        stage.setTitle("Wypożyczania sprzętu turystycznego");
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        ScreenManager.getInstance().setStage(stage);
        ScreenManager.getInstance().activate("welcomePage");
        stage.show();
    }

    private void initializeScreens() throws IOException {
        ScreenManager.getInstance().addScreen("administratorPage",
                new AppScreen("/fxml/administratorPage.fxml"));
        ScreenManager.getInstance().addScreen("customerPage",
                new AppScreen("/fxml/customerPage.fxml"));
        ScreenManager.getInstance().addScreen("employeePage",
                new AppScreen("/fxml/employeePage.fxml"));
        ScreenManager.getInstance().addScreen("loginForm",
                new AppScreen("/fxml/loginForm.fxml"));
        ScreenManager.getInstance().addScreen("makeReservationPage",
                new AppScreen("/fxml/makeReservationPage.fxml"));
        ScreenManager.getInstance().addScreen("registrationForm",
                new AppScreen("/fxml/registrationForm.fxml"));
        ScreenManager.getInstance().addScreen("reservationDetailsPage",
                new AppScreen("/fxml/reservationDetailsPage.fxml"));
        ScreenManager.getInstance().addScreen("welcomePage",
                new AppScreen("/fxml/welcomePage.fxml"));
        ScreenManager.getInstance().addScreen("addItemCategoryPage",
                new AppScreen("/fxml/addItemCategoryPage.fxml"));
        ScreenManager.getInstance().addScreen("addItemPage",
                new AppScreen("/fxml/addItemPage.fxml"));
    }

    private void initializeConnectionWithDb() {
        EntityManagerProvider.getInstance();
    }
}
