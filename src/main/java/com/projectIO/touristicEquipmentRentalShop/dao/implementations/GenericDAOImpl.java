package com.projectIO.touristicEquipmentRentalShop.dao.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.EntityManagerProvider;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

    private Class<T> type;

    public GenericDAOImpl() {
        type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        em.close();
    }

    @Override
    public T read(K identifier) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        T entity = em.find(type, identifier);
        em.close();
        return entity;
    }

    @Override
    public void update(T entity) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entity);
        transaction.commit();
        em.close();
    }

    @Override
    public void delete(K identifier) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        T entityToRemove = em.find(type, identifier);
        transaction.begin();
        em.remove(entityToRemove);
        transaction.commit();
        em.close();
    }

    @Override
    public List<T> readAll() {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        CriteriaQuery<T> c = em.getCriteriaBuilder().createQuery(type);
        c.select(c.from(type));
        List<T> entities = em.createQuery(c).getResultList();
        transaction.commit();
        em.close();
        return entities;
    }
}
