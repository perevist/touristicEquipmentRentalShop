package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ItemCategoryServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ItemServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ReservationServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemCategoryService;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemService;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ReservationService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class MakeReservationPageController implements Initializable, MainController {

    private ItemCategoryService itemCategoryService;
    private ItemService itemService;
    private ReservationService reservationService;

    private List<ItemCategory> itemCategories;
    private List<Item> itemsAddedToCard;
    private List<Item> searchedItems;
    private double totalCost;

    @FXML
    private GridPane rootPane;
    @FXML
    private TableView<Item> searchedItemsTable;
    @FXML
    private TableColumn<Item, Integer> itemIdTabColumn;
    @FXML
    private TableColumn<Item, String> categoryNameTabColumn;
    @FXML
    private TableColumn<Item, Number> chargeTabColumn;
    @FXML
    private TableColumn<Item, Number> depositTabColumn;
    @FXML
    private TableColumn<Item, String> techConditionTabColumn;
    @FXML
    private TableView<Item> cartTable;
    @FXML
    private TableColumn<Item, Number> cartItemIdTabColumn;
    @FXML
    private TableColumn<Item, String> cartCategoryNameTabColumn;
    @FXML
    private TableColumn<Item, Number> cartChargeTabColumn;
    @FXML
    private TableColumn<Item, Number> cartDepositTabColumn;
    @FXML
    private TableColumn<Item, String> cartTechConditionTabColumn;
    @FXML
    private ChoiceBox<String> itemCategoryChoiceBox;
    @FXML
    private DatePicker reservationDatePicker;
    @FXML
    private TextField rentalLengthField;
    @FXML
    private TextField totalCostTextField;
    @FXML
    private Button searchButton;
    @FXML
    private Button addToCartButton;
    @FXML
    private Button removeFromCartButton;
    @FXML
    private Button cancelReservationButton;
    @FXML
    private Button makeReservationButton;
    @FXML
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/customerPageReserImg.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void updateDataInView() {
        initializeItemCategoryChoiceBox();
        clearFields();
    }

    private void clearFields() {
        itemCategoryChoiceBox.setValue(null);
        reservationDatePicker.setDisable(false);
        reservationDatePicker.setValue(null);
        rentalLengthField.clear();
        rentalLengthField.setDisable(false);
        searchedItemsTable.getItems().clear();
        cartTable.getItems().clear();
        totalCostTextField.clear();
        totalCost = 0;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setBackground(new Background(myBI));
        itemsAddedToCard = new ArrayList<>();

        initializeServices();
        configureTableColumns();
    }

    private void initializeServices() {
        itemCategoryService = new ItemCategoryServiceImpl();
        itemService = new ItemServiceImpl();
        reservationService = new ReservationServiceImpl();
    }

    private void initializeItemCategoryChoiceBox() {
        itemCategories = itemCategoryService.getAllCategories();
        List<String> options = new ArrayList<>();

        for (ItemCategory itemCategory : itemCategories) {
            options.add(itemCategory.getName());
        }

        itemCategoryChoiceBox.getItems().setAll(options);
    }

    private void configureTableColumns() {
        itemIdTabColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        categoryNameTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCategory().getName()));
        chargeTabColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCategory().getRentalCharge()));
        depositTabColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCategory().getDeposit()));
        techConditionTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTechnicalCondition().getName()));

        cartItemIdTabColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        cartCategoryNameTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCategory().getName()));
        cartChargeTabColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCategory().getRentalCharge()));
        cartDepositTabColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCategory().getDeposit()));
        cartTechConditionTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTechnicalCondition().getName()));
    }

    @FXML
    void addToCart(ActionEvent event) {
        Item selectedItem = searchedItemsTable.getSelectionModel().selectedItemProperty().get();
        if (selectedItem == null)
            return;

        itemsAddedToCard.add(selectedItem);
        designateItemAsInCart(selectedItem);
        searchedItems.remove(selectedItem);
        updateCartTable();
        double cost = selectedItem.getCategory().getRentalCharge() + selectedItem.getCategory().getDeposit();
        updateTotalCost(cost);
        updateSearchedItemsTable();
    }

    private void designateItemAsInCart(Item item) {
        item.setInCart(true);
        itemService.updateItem(item);
    }

    private void designateItemAsNotInCart(Item item) {
        item.setInCart(false);
        itemService.updateItem(item);
    }

    private void updateSearchedItemsTable() {
        searchedItemsTable.getItems().setAll(searchedItems);
    }

    private void updateCartTable() {
        cartTable.getItems().setAll(itemsAddedToCard);
    }

    private void updateTotalCost(double cost) {
        totalCost += cost;
        totalCostTextField.setText(totalCost + " zł");
    }

    @FXML
    void cancelReservation(ActionEvent event) throws IOException {
        clearCart();
        ScreenManager.getInstance().activate("customerPage");
    }

    @FXML
    void makeReservation(ActionEvent event) throws IOException {
        if (itemsAddedToCard.isEmpty())
            return;

        LocalDate dateOfReceipt = reservationDatePicker.getValue();
        int rentalLength = Integer.parseInt(rentalLengthField.getText());
        reservationService.makeReservation(itemsAddedToCard, dateOfReceipt, rentalLength);

        clearCart();

        AlertWindow.showAlert(rootPane, "Wykonano", "Pomyślnie złożono rezerwację");
        ScreenManager.getInstance().activate("customerPage");
    }

    private void clearCart() {
        for (int i = 0; i < itemsAddedToCard.size(); i++) {
            designateItemAsNotInCart(itemsAddedToCard.get(i));
        }
        itemsAddedToCard.clear();
    }

    @FXML
    void removeFromCart(ActionEvent event) {
        Item selectedItem = cartTable.getSelectionModel().selectedItemProperty().get();
        if (selectedItem == null)
            return;

        itemsAddedToCard.remove(selectedItem);
        designateItemAsNotInCart(selectedItem);
        updateCartTable();
        double cost = selectedItem.getCategory().getRentalCharge() + selectedItem.getCategory().getDeposit();
        updateTotalCost(-cost);
        searchItems(new ActionEvent());
    }

    @FXML
    void searchItems(ActionEvent event) {
        if (!validSearchItemsForm())
            return;

        LocalDate reservationDate = reservationDatePicker.getValue();
        String itemCategoryName = itemCategoryChoiceBox.getValue();
        int itemCategoryId = getItemCategoryId(itemCategoryName);

        searchedItems = itemService.getItemsFilteredByCategoryAndAvailabilityDate(itemCategoryId, reservationDate);
        searchedItemsTable.getItems().setAll(searchedItems);
        disableSelectingDateAndRentalLength();
    }

    private void disableSelectingDateAndRentalLength() {
        reservationDatePicker.setDisable(true);
        rentalLengthField.setDisable(true);
    }

    private boolean validSearchItemsForm() {
        if (!checkAreAllFieldsFilledIn()) {
            AlertWindow.showAlert(rootPane, "Błąd", "Proszę uzupełnić wszystkie pola");
            return false;
        }

        try {
            int rentalLength = Integer.parseInt(rentalLengthField.getText());
        } catch (Exception e) {
            AlertWindow.showAlert(rootPane, "Błąd", "Proszę podac prawidlowa dlugosc rezerwacji");
            return false;
        }
        return true;
    }

    private boolean checkAreAllFieldsFilledIn() {
        if (rentalLengthField.getText().isEmpty() || reservationDatePicker.getValue() == null
                || itemCategoryChoiceBox.getValue() == null)
            return false;
        else
            return true;
    }

    private int getItemCategoryId(String itemCategoryName) {
        for (ItemCategory itemCategory : itemCategories) {
            if (itemCategory.getName().equals(itemCategoryName))
                return itemCategory.getId();
        }
        return -1;
    }
}