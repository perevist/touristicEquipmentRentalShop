package com.projectIO.touristicEquipmentRentalShop.dao.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.EntityManagerProvider;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ReservationDAO;
import com.projectIO.touristicEquipmentRentalShop.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ReservationDAOImpl extends GenericDAOImpl<Reservation, Integer> implements ReservationDAO {

    public List<Reservation> getAllReservationsFilteredByCustomerLogin(String customerLogin) {
        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"'";

        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();

        TypedQuery<Reservation> createdQuery = em.createQuery(query, Reservation.class);
        List<Reservation> result = createdQuery.getResultList();
        em.close();
        return result;
    }

    public List<Reservation> getAllReservationsFilteredByCustomerLoginAndDate(String customerLogin,
                                                                              LocalDate dateOfReceipt) {

        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"' AND " +
                "r.dateOfReceipt='" + dateOfReceipt.toString() + "'";

        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();

        TypedQuery<Reservation> createdQuery = em.createQuery(query, Reservation.class);
        em.close();

        return createdQuery.getResultList();
    }

    public List<Reservation> getAllReservationsFilteredByCustomerLoginAndReservationNumber(String customerLogin,
                                                                                           int reservationNum) {

        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"' AND " +
                "r.id=" +reservationNum;

        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();

        TypedQuery<Reservation> createdQuery = em.createQuery(query, Reservation.class);
        em.close();
        return createdQuery.getResultList();
    }
}
