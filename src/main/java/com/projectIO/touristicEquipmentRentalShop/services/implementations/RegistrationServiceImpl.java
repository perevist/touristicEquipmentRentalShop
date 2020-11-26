package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.CustomerDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.CustomerDAO;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.model.Customer;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.RegistrationService;

public class RegistrationServiceImpl  implements RegistrationService {

    private CustomerDAO customerDAO;

    public RegistrationServiceImpl() {
        customerDAO = new CustomerDAOImpl();
    }

    @Override
    public void registerCustomer(String login, String firstName, String lastName, String phoneNumber, String email,
                                 String password) {

        try {
            Customer customer = new Customer(login, firstName, lastName, phoneNumber, email, password);
            customerDAO.save(customer);
        }catch (Exception exception) {
            exception.printStackTrace();
            throw new IncorrectLoginException("Podany login jest już zajęty");
        }
    }
}
