package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Customer;
import com.projectIO.touritsitcEquipmentRentalShop.model.Employee;

public interface EmployeeDao {
    void save(Employee employee);
    Employee read(String login);
    void update(Employee employee);
    void delete(String login);
    void cleanUp();
}
