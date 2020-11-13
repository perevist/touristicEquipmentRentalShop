package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.model.Reservation;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class MakeReservationPageController implements Initializable {

    private ItemCategoryService itemCategoryService;
    private ItemService itemService;
    private ReservationService reservationService;

    private List<ItemCategory> itemCategories;
    private List<Item> itemsAddedToCard;
    private List<Item> searchedItems;
    private Reservation reservation;

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
    private Button searchButton;
    @FXML
    private Button addToCartButton;
    @FXML
    private Button removeFromCartButton;
    @FXML
    private Button cancelReservationButton;
    @FXML
    private Button makeReservationButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemCategoryService = new ItemCategoryServiceImpl();
        itemService = new ItemServiceImpl();
        reservationService = new ReservationServiceImpl();
        itemsAddedToCard = new ArrayList<>();
        reservation = new Reservation();

        initializeItemCategoryChoiceBox();
        configureTableColumns();
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
        if(selectedItem == null)
            return;

        itemsAddedToCard.add(selectedItem);
        designateItemAsInCart(selectedItem);
        searchedItems.remove(selectedItem);
        updateCartTable();
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

    @FXML
    void cancelReservation(ActionEvent event) throws IOException {
        for (int i = 0; i < itemsAddedToCard.size(); i++) {
            designateItemAsNotInCart(itemsAddedToCard.get(i));
        }

        Stage stage = (Stage) rootPane.getScene().getWindow();
        Parent pane = FXMLLoader.load(getClass().getResource("/fxml/customerPage.fxml"));
        stage.setScene(new Scene(pane, 800, 500));
    }

    @FXML
    void makeReservation(ActionEvent event) {
        if(itemsAddedToCard.isEmpty())
            return;

        reservation.setItems(itemsAddedToCard);
        reservationService.makeReservation(reservation);

        for (int i = 0; i < itemsAddedToCard.size(); i++) {
            designateItemAsNotInCart(itemsAddedToCard.get(i));
        }
    }

    @FXML
    void removeFromCart(ActionEvent event) {
        Item selectedItem = cartTable.getSelectionModel().selectedItemProperty().get();
        if(selectedItem == null)
            return;

        itemsAddedToCard.remove(selectedItem);
        designateItemAsNotInCart(selectedItem);
        updateCartTable();
        searchItems(new ActionEvent());
    }

    @FXML
    void searchItems(ActionEvent event) {
        if(!validSearchItemsForm())
            return;

        LocalDate reservationDate = reservationDatePicker.getValue();
        String itemCategoryName = itemCategoryChoiceBox.getValue();
        int itemCategoryId = getItemCategoryId(itemCategoryName);

        searchedItems = itemService.getItemsFilteredByCategoryAndAvailabilityDate(itemCategoryId, reservationDate);

        searchedItemsTable.getItems().setAll(searchedItems);
    }

    private boolean validSearchItemsForm() {
        Window window = searchButton.getScene().getWindow();

        if(!checkAreAllFieldsFilledIn()) {
            AlertWindow.showAlert(Alert.AlertType.CONFIRMATION, window, "Błąd",
                    "Proszę uzupełnić wszystkie pola");
            return false;
        }

        int rentalLength;
        try {
            rentalLength = Integer.parseInt(rentalLengthField.getText());
        } catch (Exception e){
            AlertWindow.showAlert(Alert.AlertType.CONFIRMATION, window, "Błąd",
                    "Proszę podac prawidlowa dlugosc rezerwacji");
            return false;
        }

        return true;
    }

    private boolean checkAreAllFieldsFilledIn() {
        if(rentalLengthField.getText().isEmpty() || reservationDatePicker.getValue() == null
                || itemCategoryChoiceBox.getValue() == null)
            return false;
        else
            return true;
    }

    private int getItemCategoryId(String itemCategoryName) {
        for (ItemCategory itemCategory : itemCategories) {
            if(itemCategory.getName().equals(itemCategoryName))
                return itemCategory.getId();
        }
        return -1;
    }
}