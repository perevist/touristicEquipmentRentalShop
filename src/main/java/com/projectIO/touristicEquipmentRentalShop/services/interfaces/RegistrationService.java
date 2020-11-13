package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

public interface RegistrationService {

    void registerCustomer(String login, String firstName, String lastName, String phoneNumber, String email,
                          String password);
}
