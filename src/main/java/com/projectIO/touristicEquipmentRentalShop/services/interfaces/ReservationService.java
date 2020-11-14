package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.Item;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    void makeReservation(List<Item> items, LocalDate dateOfReceipt, int rentalLength);
}
