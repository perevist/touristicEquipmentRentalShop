package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public EmployeeDaoImpl() {
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void save(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }

    @Override
    public Employee read(String login) {
        Employee employee = entityManager.find(Employee.class, login);
        return employee;
    }

    @Override
    public void update(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        Employee employeeFromDb = entityManager.find(Employee.class, employee.getLogin());
        if(employeeFromDb != null) {
            transaction.begin();
            employeeFromDb.setFirstName(employee.getFirstName());
            employeeFromDb.setLastName(employee.getLastName());
            employeeFromDb.setSalary(employee.getSalary());
            employeeFromDb.setPhoneNumber(employee.getPhoneNumber());
            employeeFromDb.setLogin(employee.getLogin());
            employeeFromDb.setPassword(employee.getPassword());
            transaction.commit();
        }

    }

    @Override
    public void delete(String login) {
        EntityTransaction transaction = entityManager.getTransaction();
        Employee employeeToRemove = entityManager.find(Employee.class, login);
        transaction.begin();
        entityManager.remove(employeeToRemove);
        transaction.commit();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
