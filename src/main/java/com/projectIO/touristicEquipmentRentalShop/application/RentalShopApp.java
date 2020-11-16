package com.projectIO.touristicEquipmentRentalShop.application;

//import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.LoginService;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.RegistrationService;

public class RentalShopApp {
    private static RentalShopApp instance;

    private RegistrationService registrationService;
    private LoginService loginService;
    
    public static void main(String[] args) {
    }

    private RentalShopApp() {
        registrationService  = (login, firstName, lastName, phoneNumber, email, password) ->
                registrationService.registerCustomer(login, firstName, lastName, phoneNumber, email, password);
        loginService = (login, password, userType) -> loginService.loginUser(login, password, userType);
    }

    public static RentalShopApp getInstance() {
        if (instance == null) {
            instance = new RentalShopApp();
        }
        return instance;
    }

}
