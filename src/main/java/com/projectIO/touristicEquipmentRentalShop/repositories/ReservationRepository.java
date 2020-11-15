package com.projectIO.touristicEquipmentRentalShop.repositories;

import com.projectIO.touristicEquipmentRentalShop.model.Reservation;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ReservationRepository extends GenericRepository<Reservation, Integer>{

    public ReservationRepository(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    public List<Reservation> getAllReservationsFilteredByCustomerLogin(String customerLogin) {
        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"'";

        TypedQuery<Reservation> createdQuery = entityManager.createQuery(query, Reservation.class);
        List<Reservation> result = createdQuery.getResultList();
        return result;
    }

    public List<Reservation> getAllReservationsFilteredByCustomerLoginAndDate(String customerLogin,
                                                                              LocalDate dateOfReceipt) {

        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"' AND " +
                "r.dateOfReceipt='" + dateOfReceipt.toString() + "'";
        TypedQuery<Reservation> createdQuery = entityManager.createQuery(query, Reservation.class);
        return createdQuery.getResultList();
    }

    public List<Reservation> getAllReservationsFilteredByCustomerLoginAndReservationNumber(String customerLogin,
                                                                              int reservationNum) {

        String query = "SELECT r FROM Reservation r WHERE r.customer='" + customerLogin +"' AND " +
                "r.id=" +reservationNum;

        TypedQuery<Reservation> createdQuery = entityManager.createQuery(query, Reservation.class);
        return createdQuery.getResultList();
    }
}
