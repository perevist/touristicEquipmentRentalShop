package com.projectIO.touristicEquipmentRentalShop.services;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectPasswordException;
import com.projectIO.touristicEquipmentRentalShop.model.Customer;
import com.projectIO.touristicEquipmentRentalShop.model.Employee;
import com.projectIO.touristicEquipmentRentalShop.model.Person;
import com.projectIO.touristicEquipmentRentalShop.repositories.CustomerRepository;
import com.projectIO.touristicEquipmentRentalShop.repositories.EmployeeRepository;

public class LoginService {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    public LoginService() {
        customerRepository = new CustomerRepository();
        employeeRepository = new EmployeeRepository();
    }

    public void loginUser(String login, String password, String userType) {

        Person personFromDb = readPersonFromDb(login, userType);

        if(personFromDb == null) {
            throw new IncorrectLoginException("Nie znaleziono użytkownika o podanym loginie");
        }

        String passwordFromDb = personFromDb.getPassword();
        if(!passwordFromDb.equals(password)){
            throw new IncorrectPasswordException("Podano nieprawidłowe hasło");
        }
    }

    private Person readPersonFromDb(String login, String userType){
        if(userType.equals("Klient")) {
            return customerRepository.read(login);
        } else{
            return employeeRepository.read(login);
        }
    }
}
