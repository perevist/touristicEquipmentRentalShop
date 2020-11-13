package com.projectIO.touristicEquipmentRentalShop.services;

import com.projectIO.touristicEquipmentRentalShop.model.Reservation;
import com.projectIO.touristicEquipmentRentalShop.repositories.ReservationRepository;

public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl() {
        reservationRepository = new ReservationRepository();
    }

    @Override
    public void makeReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
