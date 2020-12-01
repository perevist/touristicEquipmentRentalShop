package com.projectIO.touristicEquipmentRentalShop.application;

//import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.ReservationServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.LoginService;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.RegistrationService;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ReservationService;

import java.time.LocalDate;
import java.util.List;

public class RentalShopApp {
    private static RentalShopApp instance;

    private RegistrationService registrationService;
    private LoginService loginService;
    private ReservationService reservationService;
    
    public static void main(String[] args) {
    }

    private RentalShopApp() {
        registrationService  = (login, firstName, lastName, phoneNumber, email, password) ->
                registrationService.registerCustomer(login, firstName, lastName, phoneNumber, email, password);
        loginService = (login, password, userType) -> loginService.loginUser(login, password, userType);
        reservationService = new ReservationServiceImpl();
    }

    public static RentalShopApp getInstance() {
        if (instance == null) {
            instance = new RentalShopApp();
        }
        return instance;
    }
    public void makeReservation (List<Item> items, LocalDate dateOfReceipt, int rentalLength){
        reservationService.makeReservation(items, dateOfReceipt, rentalLength);
    }

}
