package com.projectIO.touristicEquipmentRentalShop.model;

public enum UserType {
    GUEST("Gość","GuestPersistenceUnit"),
    CUSTOMER("Klient","CustomerPersistenceUnit"),
    EMPLOYEE("Pracownik","EmployeePersistenceUnit"),
    ADMINISTRATOR("Administrator","AdministratorPersistenceUnit");

    private final String persistenceUnitName;
    private final String name;

    UserType(String name, String persistenceUnitName) {
        this.name = name;
        this.persistenceUnitName = persistenceUnitName;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }
}
