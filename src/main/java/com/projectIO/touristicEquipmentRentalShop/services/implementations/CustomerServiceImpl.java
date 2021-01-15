package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.CustomerDAO;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ItemCategoryDAO;
import com.projectIO.touristicEquipmentRentalShop.model.Customer;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.readAll();
    }

    @Override
    public void removeCustomer(String login){
        customerDAO.delete(login);
    }
}
