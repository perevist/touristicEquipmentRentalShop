package com.projectIO.touristicEquipmentRentalShop.gui.helpers;

import com.projectIO.touristicEquipmentRentalShop.gui.controllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class AppScreen {
    private Scene scene;
    private MainController mainController;

    public AppScreen(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        scene = new Scene(root, 1200, 800);
        mainController = loader.getController();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
