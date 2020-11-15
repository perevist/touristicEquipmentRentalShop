package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectPasswordException;
import com.projectIO.touristicEquipmentRentalShop.model.*;
import com.projectIO.touristicEquipmentRentalShop.repositories.CustomerRepository;
import com.projectIO.touristicEquipmentRentalShop.repositories.EmployeeRepository;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.LoginService;

public class LoginServiceImpl implements LoginService {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    public LoginServiceImpl() {
        String persistentUnitName = UserInSystem.getInstance().getUserType().getPersistenceUnitName();
        customerRepository = new CustomerRepository(persistentUnitName);
        employeeRepository = new EmployeeRepository(persistentUnitName);
    }

    @Override
    public void loginUser(String login, String password, UserType userType) {
        switch (userType) {
            case CUSTOMER:
                loginCustomer(login, password, userType);
                break;
            case EMPLOYEE: case ADMINISTRATOR:
                loginEmployee(login, password, userType);
                break;
        }

        UserInSystem userInSystem = UserInSystem.getInstance();
        userInSystem.setLogin(login);
        userInSystem.setUserType(userType);
    }

    private void loginCustomer(String login, String password, UserType userType) {
        customerRepository.setPersistenceUnitName(userType.getPersistenceUnitName());
        Customer customerFromDb = customerRepository.read(login);

        if(customerFromDb == null) {
            throw new IncorrectLoginException("Nie znaleziono użytkownika o podanym loginie");
        }

        verifyPassword(customerFromDb, password);
    }

    private void verifyPassword(Person personFromDb, String password) {
        String passwordFromDb = personFromDb.getPassword();
        if (!passwordFromDb.equals(password)) {
            throw new IncorrectPasswordException("Podano nieprawidłowe hasło");
        }
    }

    private void loginEmployee(String login, String password, UserType userType) {
        employeeRepository.setPersistenceUnitName(userType.getPersistenceUnitName());
        Employee employeeFromDb = employeeRepository.read(login);

        if(employeeFromDb == null) {
            throw new IncorrectLoginException("Nie znaleziono użytkownika o podanym loginie");
        }

        verifyPassword(employeeFromDb, password);
        checkIfPositionIsCorrect(employeeFromDb, userType);
    }

    private void checkIfPositionIsCorrect(Employee employee, UserType userType) {
        if(userType == UserType.ADMINISTRATOR){
            Position position = employee.getPosition();
            // 2 - id of administrator's position
            if(position.getId() != 2) {
                throw new IncorrectLoginException("Nie znaleziono użytkownika o podanym loginie");
            }
        }

        if(userType == UserType.EMPLOYEE){
            Position position = employee.getPosition();
            // 1 - id 'wypozyczajacy'
            if(position.getId() != 1) {
                throw new IncorrectLoginException("Nie znaleziono użytkownika o podanym loginie");
            }
        }
    }
}
