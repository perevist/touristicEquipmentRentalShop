package com.projectIO.touristicEquipmentRentalShop.model;

public class UserLoggedInSystem {
    private static String login;
    private UserLoggedInSystem instance;

    public UserLoggedInSystem getInstance() {
        if(instance == null)
            return new UserLoggedInSystem();
        else
            return instance;
    }

    private UserLoggedInSystem() {
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        UserLoggedInSystem.login = login;
    }
}
