package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class EmployeePageController implements MainController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button addItemCategoryButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button addItemButton;

    @FXML
    void addItem(ActionEvent event) {

    }

    @FXML
    void addItemCategory(ActionEvent event) {
        ScreenManager.getInstance().activate("addItemCategoryPage");
    }

    @FXML
    void logout(ActionEvent event) {
        ScreenManager.getInstance().activate("welcomePage");
    }

    @Override
    public void updateDataInView() {
    }
}
