package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

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
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/employeePage.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @FXML
    void addItem(ActionEvent event) {
        ScreenManager.getInstance().activate("addItemPage");
    }

    @FXML
    void addItemCategory(ActionEvent event) {
        ScreenManager.getInstance().activate("addItemCategoryPage");
    }

    @FXML
    void logout(ActionEvent event) {
        UserInSystem.getInstance().setUserType(UserType.GUEST);
        ScreenManager.getInstance().activate("welcomePage");
    }

    @FXML
    public void initialize(){
        rootPane.setBackground(new Background(myBI));
    }
    @Override
    public void updateDataInView() {
    }
}
