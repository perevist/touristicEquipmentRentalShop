package com.projectIO.touristicEquipmentRentalShop.dao.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO extends GenericDAO<Reservation,Integer> {

    List<Reservation> getAllReservationsFilteredByCustomerLogin(String customerLogin);
    List<Reservation> getAllReservationsFilteredByCustomerLoginAndDate(String customerLogin,
                                                                       LocalDate dateOfReceipt);
    List<Reservation> getAllReservationsFilteredByCustomerLoginAndReservationNumber(String customerLogin,
                                                                                    int reservationNum);

    List<Reservation> getAllReservationsFilteredByDate(LocalDate dateOfReceipt);
    List<Reservation> getAllReservationsFilteredByReservationNumber(int number);
}
