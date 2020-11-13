package com.projectIO.touristicEquipmentRentalShop.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;

public abstract class GenericRepository<T, K> {

    protected EntityManagerFactory emFactory;
    protected EntityManager entityManager;
    private Class<T> type;

    public GenericRepository(String persistenceUnitName) {
        emFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = emFactory.createEntityManager();
        type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public T read(K identifier) {
        T entity = entityManager.find(type, identifier);
        return entity;
    }

    public void update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    public void delete(K identifier) {
        EntityTransaction transaction = entityManager.getTransaction();
        T entityToRemove = entityManager.find(type, identifier);
        transaction.begin();
        entityManager.remove(entityToRemove);
        transaction.commit();
    }

    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
