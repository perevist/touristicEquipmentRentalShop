package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.gui.helpers.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.Reservation;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ReservationServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ReservationService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationDetailsPageController implements Initializable, MainController {

    private ReservationService reservationService;

    @FXML
    private GridPane rootPane;
    @FXML
    private TableView<Reservation> searchedIReservationsTable;
    @FXML
    private TableColumn<Reservation, Number> reservationIdTabColumn;
    @FXML
    private TableColumn<Reservation, String> dateOfReceiptTabColumn;
    @FXML
    private TableColumn<Reservation, Integer> rentalLengthTabColumn;
    @FXML
    private TableColumn<Reservation, String> statusTabColumn;
    @FXML
    private TableView<Item> itemsInReservationTable;
    @FXML
    private TableColumn<Item, Number> itemIdTabColumn;
    @FXML
    private TableColumn<Item, String> categoryNameTabColumn;
    @FXML
    private TableColumn<Item, Number> chargeTabColumn;
    @FXML
    private TableColumn<Item, Number> depositTabColumn;
    @FXML
    private TableColumn<Item, String> techConditionTabColumn;

    @FXML
    private DatePicker reservationDatePicker;
    @FXML
    private TextField reservationNumberField;
    @FXML
    private Button searchButton;
    @FXML
    private Button cancelReservationButton;
    @FXML
    private Button returnButton;
    @FXML
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/customerPageReserImg.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    @Override
    public void updateDataInView() {
        initializeTable();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setBackground(new Background(myBI));
        initializeServices();
        configureTableColumns();
    }

    private void initializeServices() {
        reservationService = new ReservationServiceImpl();
    }

    private void configureTableColumns() {
        reservationIdTabColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateOfReceiptTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDateOfReceipt().toString()));
        rentalLengthTabColumn.setCellValueFactory(new PropertyValueFactory<>("rentalLength"));
        statusTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStatus().getName()));

        itemIdTabColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        categoryNameTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCategory().getName()));
        chargeTabColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCategory().getRentalCharge()));
        depositTabColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCategory().getDeposit()));
        techConditionTabColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTechnicalCondition().getName()));
    }

    private void initializeTable() {
        searchAllReservations();

        searchedIReservationsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null) {
                        List<Item> items = newValue.getItems();
                        itemsInReservationTable.getItems().setAll(items);
                    }
                }
        );
    }

    private void searchAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservationsOfCurrentlyLoggedUser();
        searchedIReservationsTable.getItems().setAll(reservations);
    }

    @FXML
    void cancelReservation(ActionEvent event) {
        Reservation reservationToRemove = searchedIReservationsTable.getSelectionModel().getSelectedItem();
        if(reservationToRemove == null) {
            AlertWindow.showAlert(rootPane, "Błąd", "Proszę wybrać rezerwację z listy");
            return;
        }

        int reservationId = reservationToRemove.getId();
        reservationService.cancelReservation(reservationId);
        clearItemsInReservationTable();
        searchAllReservations();
    }

    private void clearItemsInReservationTable() {
        List<Item> items = new ArrayList<>();
        itemsInReservationTable.getItems().setAll(items);
    }

    @FXML
    public void searchReservations(ActionEvent event) {
        boolean isReservationDatePickerFilledIn = reservationDatePicker.getValue() != null;
        boolean isReservationNumberFieldFilledIn = !reservationNumberField.getText().isEmpty();

        if(isReservationDatePickerFilledIn && isReservationNumberFieldFilledIn) {
            AlertWindow.showAlert(rootPane, "Błąd", "Istnieje możliwość filtrowania tylko po jednym kryterium");
        }
        else if(isReservationDatePickerFilledIn){
            searchReservationsByDate();
        }else if(isReservationNumberFieldFilledIn) {
            searchReservationsByNumber();
        }
        else {
            searchAllReservations();
        }
    }

    private void searchReservationsByDate() {
        LocalDate dateOfReceipt = reservationDatePicker.getValue();
        List<Reservation> reservations =
                reservationService.getAllReservationsOfCurrentlyLoggedUserFilteredByDate(dateOfReceipt);

        searchedIReservationsTable.getItems().setAll(reservations);
    }

    private void searchReservationsByNumber() {
        int reservationNumber = 0;

        try{
            reservationNumber = Integer.parseInt(reservationNumberField.getText());
        }catch (Exception exception) {
            AlertWindow.showAlert(rootPane,"Błąd", "Prosze podac wartosc liczbowa w polu: numer rezerwacji");
            return;
        }

        List<Reservation> reservations =
                reservationService.getAllReservationsOfCurrentlyLoggedUserFilteredByReservationNumber(reservationNumber);
        searchedIReservationsTable.getItems().setAll(reservations);
    }

    @FXML
    void returnToCustomerPage(ActionEvent event) throws IOException {
        ScreenManager.getInstance().activate("customerPage");
    }
}