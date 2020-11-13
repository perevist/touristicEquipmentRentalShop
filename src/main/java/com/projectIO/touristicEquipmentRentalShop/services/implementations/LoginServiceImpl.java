package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectPasswordException;
import com.projectIO.touristicEquipmentRentalShop.model.Person;
import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import com.projectIO.touristicEquipmentRentalShop.repositories.CustomerRepository;
import com.projectIO.touristicEquipmentRentalShop.repositories.EmployeeRepository;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.LoginService;

public class LoginServiceImpl implements LoginService {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    public LoginServiceImpl() {
        customerRepository = new CustomerRepository();
        employeeRepository = new EmployeeRepository();
    }

    @Override
    public void loginUser(String login, String password, UserType userType) {
        Person personFromDb = readPersonFromDb(login, userType);

        if (personFromDb == null) {
            throw new IncorrectLoginException("Nie znaleziono użytkownika o podanym loginie");
        }

        String passwordFromDb = personFromDb.getPassword();
        if (!passwordFromDb.equals(password)) {
            throw new IncorrectPasswordException("Podano nieprawidłowe hasło");
        }
    }

    private Person readPersonFromDb(String login, UserType userType) {
        switch (userType) {
            case CUSTOMER:
                return customerRepository.read(login);
            case EMPLOYEE:
                return employeeRepository.read(login);
            case ADMINISTRATOR:
                return null;
        }
        return null;
    }
}
