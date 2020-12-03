package com.projectIO.touristicEquipmentRentalShop.dao.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.EntityManagerProvider;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ReservationDAO;
import com.projectIO.touristicEquipmentRentalShop.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ReservationDAOImpl extends GenericDAOImpl<Reservation, Integer> implements ReservationDAO {

    @Override
    public List<Reservation> getAllReservationsFilteredByCustomerLogin(String customerLogin) {
        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"'";
        return executeQuery(query);
    }

    @Override
    public List<Reservation> getAllReservationsFilteredByCustomerLoginAndDate(String customerLogin,
                                                                              LocalDate dateOfReceipt) {

        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"' AND " +
                "r.dateOfReceipt='" + dateOfReceipt.toString() + "'";
        return executeQuery(query);
    }

    @Override
    public List<Reservation> getAllReservationsFilteredByCustomerLoginAndReservationNumber(String customerLogin,
                                                                                           int reservationNum) {
        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"' AND " +
                "r.id=" +reservationNum;
        return executeQuery(query);
    }

    @Override
    public List<Reservation> getAllReservationsFilteredByDate(LocalDate dateOfReceipt) {
        String query = "SELECT r FROM Reservation r WHERE r.dateOfReceipt='" + dateOfReceipt.toString() + "'";
        return executeQuery(query);
    }

    @Override
    public List<Reservation> getAllReservationsFilteredByReservationNumber(int reservationNum) {
        String query = "SELECT r FROM Reservation r WHERE r.id=" +reservationNum;
        return executeQuery(query);
    }

    private List<Reservation> executeQuery(String query) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Reservation> createdQuery = em.createQuery(query, Reservation.class);
        List<Reservation> reservations = createdQuery.getResultList();
        transaction.commit();
        em.close();
        return reservations;
    }
}
