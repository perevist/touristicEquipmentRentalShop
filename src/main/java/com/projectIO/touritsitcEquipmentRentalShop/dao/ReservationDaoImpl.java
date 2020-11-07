package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ReservationDaoImpl implements ReservationDao{

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public ReservationDaoImpl() {
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void save(Reservation reservation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(reservation);
        transaction.commit();
    }

    @Override
    public Reservation read(int id) {
        Reservation reservation = entityManager.find(Reservation.class, id);
        return reservation;
    }

    @Override
    public void update(Reservation reservation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(reservation);
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        Reservation reservationToRemove = entityManager.find(Reservation.class, id);
        transaction.begin();
        entityManager.remove(reservationToRemove);
        transaction.commit();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
