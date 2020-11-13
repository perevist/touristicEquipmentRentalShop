package com.projectIO.touristicEquipmentRentalShop.application;

import com.projectIO.touristicEquipmentRentalShop.services.implementations.LoginServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.RegistrationServiceImpl;

public class RentalShopApp {
    private static RentalShopApp instance;

    private RegistrationServiceImpl registrationServiceImpl;
    private LoginServiceImpl loginServiceImpl;
    
    public static void main(String[] args) {
    }

    private RentalShopApp() {
        registrationServiceImpl = new RegistrationServiceImpl();
        loginServiceImpl = new LoginServiceImpl();
    }

    public static RentalShopApp getInstance() {
        if (instance == null) {
            instance = new RentalShopApp();
        }
        return instance;
    }

    public void registerCustomerInSystem(String login, String firstName, String lastName, String phoneNumber,
                                         String email, String password) {

        registrationServiceImpl.registerCustomer(login, firstName, lastName, phoneNumber, email, password);
    }

    public void loginUserInSystem(String login, String password, String userType) {
        loginServiceImpl.loginUser(login, password, userType);
    }
}
