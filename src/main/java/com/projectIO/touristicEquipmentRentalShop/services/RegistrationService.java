package com.projectIO.touristicEquipmentRentalShop.services;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.model.Customer;
import com.projectIO.touristicEquipmentRentalShop.repositories.CustomerRepository;

public class RegistrationService {

    private CustomerRepository customerRepository;

    public RegistrationService() {
        customerRepository = new CustomerRepository();
    }

    public void registerCustomer(String login, String firstName, String lastName, String phoneNumber, String email,
                                 String password) {

        try {
            Customer customer = new Customer(login, firstName, lastName, phoneNumber, email, password);
            customerRepository.save(customer);
        }catch (Exception exception) {
            throw new IncorrectLoginException("Podany login jest już zajęty");
        }
    }
}
