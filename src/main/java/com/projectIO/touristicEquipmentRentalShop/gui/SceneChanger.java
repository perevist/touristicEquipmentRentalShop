package com.projectIO.touristicEquipmentRentalShop.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    public static void changeScene(Pane rootPane, Class<?> cl, String filePath) throws IOException {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        Parent pane = FXMLLoader.load(cl.getResource(filePath));
        stage.setScene(new Scene(pane, 900, 500));
        stage.show();
    }
}
