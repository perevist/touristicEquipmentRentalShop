package com.projectIO.touristicEquipmentRentalShop.repositories;

import com.projectIO.touristicEquipmentRentalShop.model.Customer;

public class CustomerRepository extends GenericRepository<Customer, String> {

    public CustomerRepository(String persistenceUnitName) {
        super(persistenceUnitName);
    }
}