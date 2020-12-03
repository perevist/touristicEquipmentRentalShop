package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.Reservation;
import com.projectIO.touristicEquipmentRentalShop.model.Status;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    void makeReservation(List<Item> items, LocalDate dateOfReceipt, int rentalLength);
    List<Reservation> getAllReservations();
    List<Reservation> getAllReservationsFilteredByDate(LocalDate dateOfReceipt);
    List<Reservation> getAllReservationsFilteredByReservationNumber(int number);
    List<Reservation> getAllReservationsOfCurrentlyLoggedUser();
    List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByDate(LocalDate dateOfReceipt);
    List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByReservationNumber(int number);
    void cancelReservation(int id);
    void changeStatus(int reservationId, Status status);
}
