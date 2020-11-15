package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    void makeReservation(List<Item> items, LocalDate dateOfReceipt, int rentalLength);
    List<Reservation> getAllReservationsOfCurrentlyLoggedUser();
    List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByDate(LocalDate dateOfReceipt);
    List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByReservationNumber(int number);
    void cancelReservation(int id);
}
