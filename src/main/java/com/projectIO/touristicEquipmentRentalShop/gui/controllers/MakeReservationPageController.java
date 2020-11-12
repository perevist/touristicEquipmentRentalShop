package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MakeReservationPageController implements Initializable {

    @FXML
    private GridPane rootPane;
    @FXML
    private TableView<?> searchedItemsTable;
    @FXML
    private TableView<?> cartTable;
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

    }

    @FXML
    void addToCart(ActionEvent event) {

    }

    @FXML
    void cancelReservation(ActionEvent event) {

    }

    @FXML
    void makeReservation(ActionEvent event) {

    }

    @FXML
    void removeFromCart(ActionEvent event) {

    }

    @FXML
    void searchItems(ActionEvent event) {

    }
}