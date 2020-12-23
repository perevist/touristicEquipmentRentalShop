package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.ItemCategoryDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ItemCategoryServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemCategoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemCategoryController implements Initializable, MainController{

    private ItemCategoryService itemCategoryService;

    @FXML
    private GridPane rootPane;
    @FXML
    private TextField nameField;
    @FXML
    private TextField rentalChargeField;
    @FXML
    private TextField depositField;
    @FXML
    private Button returnButton;
    @FXML
    private Button addItemCategoryButton;
    @FXML
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/employeePageBlur.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setBackground(new Background(myBI));
        itemCategoryService = new ItemCategoryServiceImpl(new ItemCategoryDAOImpl());
    }

    @Override
    public void updateDataInView() {
    }

    @FXML
    void addItemCategory(ActionEvent event) {
        if (!checkAreAllFieldsFilledIn()) {
            AlertWindow.showAlert(rootPane, "Błąd", "Proszę uzupełnić wszystkie pola");
            return;
        }

        String name = nameField.getText();
        double rentalCharge = 0;
        double deposit = 0;

        try {
            rentalCharge = Double.parseDouble(rentalChargeField.getText());
            deposit = Double.parseDouble(depositField.getText());
        }catch (Exception e) {
            AlertWindow.showAlert(rootPane, "Błąd", "Proszę wprowadzić wartości liczbowe");
            return;
        }

        itemCategoryService.addItemCategory(name, rentalCharge, deposit);
        AlertWindow.showAlert(rootPane, "Wykonano", "Pomyślnie dodano nową kategorię");
        ScreenManager.getInstance().activate("employeePage");
    }

    @FXML
    void returnToEmployeePage(ActionEvent event) {
        ScreenManager.getInstance().activate("employeePage");
    }

    private boolean checkAreAllFieldsFilledIn() {
        if(nameField.getText().isEmpty() || rentalChargeField.getText().isEmpty() || depositField.getText().isEmpty()) {
            return false;
        }else{
            return true;
        }
    }
}
