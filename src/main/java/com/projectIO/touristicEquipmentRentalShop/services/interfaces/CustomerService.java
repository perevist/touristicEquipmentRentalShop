package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();
    public void removeCustomer(String login);

}
