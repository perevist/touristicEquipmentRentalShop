package com.projectIO.touristicEquipmentRentalShop.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGuiApp extends Application {

    public static void main(String[] args) {
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
}
