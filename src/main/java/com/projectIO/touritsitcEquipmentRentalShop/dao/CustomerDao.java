package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Customer;
import com.projectIO.touritsitcEquipmentRentalShop.model.Item;

public interface CustomerDao {
    void save(Customer customer);
    Customer read(String login);
    void update(Customer customer);
    void delete(String login);
    void cleanUp();
}
