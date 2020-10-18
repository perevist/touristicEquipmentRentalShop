package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.ItemCategory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ItemCategoryDaoImpl implements ItemCategoryDao{

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public ItemCategoryDaoImpl() {
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void save(ItemCategory itemCategory) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(itemCategory);
        transaction.commit();
    }

    @Override
    public ItemCategory read(Integer id) {
        ItemCategory itemCategory = entityManager.find(ItemCategory.class, id);
        return itemCategory;
    }

    @Override
    public void update(ItemCategory itemCategory) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(itemCategory);
        transaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        ItemCategory itemCategoryToRemove = entityManager.find(ItemCategory.class, id);
        transaction.begin();
        entityManager.remove(itemCategoryToRemove);
        transaction.commit();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
