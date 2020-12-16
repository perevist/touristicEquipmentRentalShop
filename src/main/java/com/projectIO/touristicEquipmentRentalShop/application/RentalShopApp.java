package com.projectIO.touristicEquipmentRentalShop.application;

//import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import com.projectIO.touristicEquipmentRentalShop.model.*;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.*;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class RentalShopApp {
    private static RentalShopApp instance;

    private RegistrationService registrationService;
    private LoginService loginService;
    private ReservationService reservationService;
    private ItemService itemService;
    private ItemCategoryService itemCategoryService;
    
    public static void main(String[] args) {

    }

    private RentalShopApp() {
        registrationService = new RegistrationServiceImpl();
        loginService = new LoginServiceImpl();
        reservationService = new ReservationServiceImpl();
        itemService = new ItemServiceImpl();
        itemCategoryService = new ItemCategoryServiceImpl();
    }

    public static RentalShopApp getInstance() {
        if (instance == null) {
            instance = new RentalShopApp();
        }
        return instance;
    }

    public void registerCustomerSystem(String login, String firstName, String lastName, String phoneNumber, String email,
                                       String password) {

        registrationService.registerCustomer(login, firstName, lastName, phoneNumber, email, password);
    }

    public void loginUserInSystem(String login, String password, UserType userType) {
        loginService.loginUser(login, password, userType);
    }

    public void makeReservation (List<Item> items, LocalDate dateOfReceipt, int rentalLength){
        reservationService.makeReservation(items, dateOfReceipt, rentalLength);
    }

    public void changeReservation(int reservationId, Status status) {
        reservationService.changeStatus(reservationId, status);
    }

    public List<Reservation> getAllReservationsOfCurrentlyLoggedUser() {
        return reservationService.getAllReservationsOfCurrentlyLoggedUser();
    }

    public void cancelReservation(int reservationId) {
        reservationService.cancelReservation(reservationId);
    }

    public void updateItem(Item item) {
        itemService.updateItem(item);
    }

    public void addNewItem(ItemCategory itemCategory, TechnicalCondition technicalCondition) {
        itemService.addItem(itemCategory, technicalCondition);
    }

    public void removeItem(int itemId) {
        itemService.removeItem(itemId);
    }

    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    public List<ItemCategory> getAllCategories() {
        return itemCategoryService.getAllCategories();
    }

    public void addNewCategory(String name, double rentalCharge, double deposit) {
        itemCategoryService.addItemCategory(name, rentalCharge, deposit);
    }

    public void updateCategory(ItemCategory itemCategory) {
        itemCategoryService.updateItemCategory(itemCategory);
    }

    public void removeCategory(int categoryId) {
        itemCategoryService.removeItemCategory(categoryId);
    }
}
