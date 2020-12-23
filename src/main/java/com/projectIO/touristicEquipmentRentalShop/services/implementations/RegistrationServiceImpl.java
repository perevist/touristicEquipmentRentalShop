package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.CustomerDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.CustomerDAO;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.model.Customer;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.RegistrationService;
import org.jasypt.util.password.BasicPasswordEncryptor;

public class RegistrationServiceImpl  implements RegistrationService {

    private CustomerDAO customerDAO;
    private BasicPasswordEncryptor passwordEncryptor;

    public RegistrationServiceImpl() {
        customerDAO = new CustomerDAOImpl();
        passwordEncryptor = new BasicPasswordEncryptor();
    }

    @Override
    public void registerCustomer(String login, String firstName, String lastName, String phoneNumber, String email,
                                 String password) {

        if(login.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Nalezy podac wszystkie dane potrzebne do rejestracji");
        }

        String encryptedPassword = passwordEncryptor.encryptPassword(password);

        try {
            Customer customer = new Customer(login, firstName, lastName, phoneNumber, email, encryptedPassword);
            customerDAO.save(customer);
        }catch (Exception e) {
            System.out.println(e.getClass());
            throw new IncorrectLoginException("Podany login jest już zajęty");
        }
    }
}
