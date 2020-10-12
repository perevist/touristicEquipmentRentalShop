package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ItemDaoImpl implements ItemDao{

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public ItemDaoImpl() {
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void save(Item item) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(item);
        transaction.commit();
    }

    @Override
    public Item read(Long id) {
        Item item = entityManager.find(Item.class, id);
        return item;
    }

    @Override
    public void update(Item item) {
        EntityTransaction transaction = entityManager.getTransaction();
        Item itemFromDb = entityManager.find(Item.class, item.getId());
        if(itemFromDb != null) {
            transaction.begin();
            itemFromDb.setAvailability(item.getAvailability());
            itemFromDb.setTechnicalCondition(item.getTechnicalCondition());
            itemFromDb.setProducer(item.getProducer());
            transaction.commit();
        }
    }

    @Override
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        Item itemToRemove = entityManager.find(Item.class, id);
        transaction.begin();
        entityManager.remove(itemToRemove);
        transaction.commit();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }

}
