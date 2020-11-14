package com.projectIO.touristicEquipmentRentalShop.model;

public class UserInSystem {
    private Person person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
