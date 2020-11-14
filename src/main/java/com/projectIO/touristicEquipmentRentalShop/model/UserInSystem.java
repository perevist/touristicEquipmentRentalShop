package com.projectIO.touristicEquipmentRentalShop.model;

public class UserInSystem {
    private String login;
    private UserType userType;

    private static UserInSystem instance;

    public static UserInSystem getInstance() {
        if (instance == null){
            instance = new UserInSystem();
        }
        return instance;
    }

    private UserInSystem() {
        userType = UserType.GUEST;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
