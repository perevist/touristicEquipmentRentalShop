package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.CustomerDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.implementations.EmployeeDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.CustomerDAO;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.EmployeeDAO;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectPasswordException;
import com.projectIO.touristicEquipmentRentalShop.model.*;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.LoginService;
import org.jasypt.util.password.BasicPasswordEncryptor;

public class LoginServiceImpl implements LoginService {

    private CustomerDAO customerDAO;
    private EmployeeDAO employeeDAO;
    private BasicPasswordEncryptor passwordEncryptor;

    public LoginServiceImpl() {
        customerDAO = new CustomerDAOImpl();
        employeeDAO = new EmployeeDAOImpl();
        passwordEncryptor = new BasicPasswordEncryptor();
    }

    @Override
    public void loginUser(String login, String password, UserType userType) {
        switch (userType) {
            case CUSTOMER:
                loginCustomer(login, password);
                break;
            case EMPLOYEE: case ADMINISTRATOR:
                loginEmployee(login, password, userType);
                break;
        }

        UserInSystem userInSystem = UserInSystem.getInstance();
        userInSystem.setLogin(login);
        userInSystem.setUserType(userType);
    }

    private void loginCustomer(String login, String password) {
        Customer customerFromDb = customerDAO.read(login);

        if(customerFromDb == null) {
            throw new IncorrectLoginException("Nie znaleziono użytkownika o podanym loginie");
        }

        verifyPassword(customerFromDb, password);
    }

    private void verifyPassword(Person personFromDb, String password) {
        String passwordFromDb = personFromDb.getPassword();
        if (!passwordEncryptor.checkPassword(password, passwordFromDb)) {
            throw new IncorrectPasswordException("Podano nieprawidłowe hasło");
        }
    }

    private void loginEmployee(String login, String password, UserType userType) {
        Employee employeeFromDb = employeeDAO.read(login);

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
