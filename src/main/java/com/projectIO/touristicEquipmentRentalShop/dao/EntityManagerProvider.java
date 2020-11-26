package com.projectIO.touristicEquipmentRentalShop.dao;

import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.model.UserType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private EntityManagerFactory emFactoryGuest;
    private EntityManagerFactory emFactoryCustomer;
    private EntityManagerFactory emFactoryEmployee;
    private EntityManagerFactory emFactoryAdministrator;

    private static EntityManagerProvider instance;

    public static EntityManagerProvider getInstance() {
        if (instance == null) {
            instance = new EntityManagerProvider();
        }
        return instance;
    }

    private EntityManagerProvider() {
        emFactoryGuest = Persistence.createEntityManagerFactory(UserType.GUEST.getPersistenceUnitName());
        emFactoryCustomer = Persistence.createEntityManagerFactory(UserType.CUSTOMER.getPersistenceUnitName());
        emFactoryEmployee = Persistence.createEntityManagerFactory(UserType.EMPLOYEE.getPersistenceUnitName());
        emFactoryAdministrator = Persistence.createEntityManagerFactory(UserType.ADMINISTRATOR.getPersistenceUnitName());
    }

    public EntityManager getEntityManager() {
        UserType userType = UserInSystem.getInstance().getUserType();

        switch (userType) {
            case GUEST:
                return emFactoryGuest.createEntityManager();
            case CUSTOMER:
                return emFactoryCustomer.createEntityManager();
            case EMPLOYEE:
                return emFactoryEmployee.createEntityManager();
            case ADMINISTRATOR:
                return emFactoryAdministrator.createEntityManager();
            default:
                return null;
        }
    }
}
