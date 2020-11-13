package com.projectIO.touristicEquipmentRentalShop.model;

public enum UserType {
    GUEST("GuestPersistenceUnit"),
    CUSTOMER("CustomerPersistenceUnit"),
    EMPLOYEE("EmployeePersistenceUnit"),
    ADMINISTRATOR("AdministratorPersistenceUnit");

    private final String persistenceUnitName;

    UserType(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }
}
