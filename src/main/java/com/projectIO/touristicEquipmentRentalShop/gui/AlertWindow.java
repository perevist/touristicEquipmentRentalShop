package com.projectIO.touristicEquipmentRentalShop.gui;

import javafx.scene.layout.Pane;
import javafx.stage.Window;
import javafx.scene.control.Alert;

public class AlertWindow {

    public static void showAlert(javafx.scene.control.Alert.AlertType alertType, Window owner, String title,
                                 String message) {

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void showAlert(Pane rootPane, String title, String message) {
        Window window = rootPane.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(window);
        alert.show();
    }
}
