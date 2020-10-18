package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Customer;
import com.projectIO.touritsitcEquipmentRentalShop.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerDaoImpl implements CustomerDao {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public CustomerDaoImpl() {
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();
    }

    @Override
    public Customer read(String login) {
        Customer customer = entityManager.find(Customer.class, login);
        return customer;
    }

    @Override
    public void update(Customer customer) {
        EntityTransaction transaction = entityManager.getTransaction();
        Customer customerFromDb = entityManager.find(Customer.class, customer.getLogin());
        if(customerFromDb != null) {
            transaction.begin();
            customerFromDb.setFirstName(customer.getFirstName());
            customerFromDb.setLastName(customer.getLastName());
            customerFromDb.setEmail(customer.getEmail());
            customerFromDb.setPhoneNumber(customer.getPhoneNumber());
            customerFromDb.setLogin(customer.getLogin());
            customerFromDb.setPassword(customer.getPassword());
            transaction.commit();
        }
    }

    @Override
    public void delete(String login) {
        EntityTransaction transaction = entityManager.getTransaction();
        Customer customerToRemove = entityManager.find(Customer.class, login);
        transaction.begin();
        entityManager.remove(customerToRemove);
        transaction.commit();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
