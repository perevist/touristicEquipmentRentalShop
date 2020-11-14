package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.model.Customer;
import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.repositories.CustomerRepository;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.RegistrationService;

public class RegistrationServiceImpl  implements RegistrationService {

    private CustomerRepository customerRepository;

    public RegistrationServiceImpl() {
        String persistenceUnitName = UserInSystem.getInstance().getUserType().getPersistenceUnitName();
        customerRepository = new CustomerRepository(persistenceUnitName);
    }

    @Override
    public void registerCustomer(String login, String firstName, String lastName, String phoneNumber, String email,
                                 String password) {

        try {
            Customer customer = new Customer(login, firstName, lastName, phoneNumber, email, password);
            customerRepository.save(customer);
        }catch (Exception exception) {
            exception.printStackTrace();
            throw new IncorrectLoginException("Podany login jest już zajęty");
        }
    }
}
