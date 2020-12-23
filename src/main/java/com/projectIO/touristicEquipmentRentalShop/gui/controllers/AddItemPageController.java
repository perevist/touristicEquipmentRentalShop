package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.ItemCategoryDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.implementations.ItemDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.implementations.TechnicalConditionDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.TechnicalConditionDAO;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.model.TechnicalCondition;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ItemCategoryServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ItemServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.TechnicalConditionServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemCategoryService;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemService;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.TechnicalConditionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;

public class AddItemPageController implements MainController, Initializable {

    private ItemCategoryService itemCategoryService;
    private TechnicalConditionService technicalConditionService;
    private ItemService itemService;

    private List<ItemCategory> itemCategories;
    private List<TechnicalCondition> technicalConditions;

    @FXML
    private GridPane rootPane;

    @FXML
    private Button addItemButton;

    @FXML
    private Button returnButton;

    @FXML
    private ChoiceBox<String> itemCategoryChoiceBox;

    @FXML
    private ChoiceBox<String> technicalConditionChoiceBox;
    @FXML
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/employeePageBlur.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setBackground(new Background(myBI));
        itemCategoryService = new ItemCategoryServiceImpl(new ItemCategoryDAOImpl());
        technicalConditionService = new TechnicalConditionServiceImpl(new TechnicalConditionDAOImpl());
        itemService = new ItemServiceImpl(new ItemDAOImpl());
    }

    @Override
    public void updateDataInView() {
        itemCategories = itemCategoryService.getAllCategories();
        technicalConditions = technicalConditionService.getAllTechnicalConditions();

        List<String> options = new ArrayList<>();
        for (ItemCategory itemCategory : itemCategories) {
            options.add(itemCategory.getName());
        }
        itemCategoryChoiceBox.getItems().setAll(options);

        options = new ArrayList<>();
        for (TechnicalCondition technicalCondition : technicalConditions) {
            options.add(technicalCondition.getName());
        }
        technicalConditionChoiceBox.getItems().setAll(options);
    }

    @FXML
    void addItem(ActionEvent event) {
        if(!checkIfChoiceBoxesAreFilledIn()) {
            AlertWindow.showAlert(rootPane, "Bład", "Proszę uzupełnić wszystkie pola");
            return;
        }

        String itemCategoryName = itemCategoryChoiceBox.getValue();
        String technicalConditionName = technicalConditionChoiceBox.getValue();
        ItemCategory itemCategory = findItemCategory(itemCategoryName);
        TechnicalCondition technicalCondition = findTechnicalCondition(technicalConditionName);

        itemService.addItem(itemCategory, technicalCondition);

        AlertWindow.showAlert(rootPane, "Wykonano", "Dodano nowy egzemplarz");
        ScreenManager.getInstance().activate("employeePage");
    }

    private ItemCategory findItemCategory(String itemCategoryName) {
        for (ItemCategory itemCategory : itemCategories) {
            if(itemCategory.getName().equals(itemCategoryName))
                return itemCategory;
        }
        return null;
    }

    private TechnicalCondition findTechnicalCondition(String technicalConditionName) {
        for (TechnicalCondition technicalCondition : technicalConditions) {
            if(technicalCondition.getName().equals(technicalConditionName))
                return technicalCondition;
        }
        return null;
    }

    @FXML
    void returnToEmployeePage(ActionEvent event) {
        ScreenManager.getInstance().activate("employeePage");
    }

    private boolean checkIfChoiceBoxesAreFilledIn() {
        if(itemCategoryChoiceBox.getValue() == null || technicalConditionChoiceBox.getValue() == null){
            return false;
        }else {
            return true;
        }
    }
}
