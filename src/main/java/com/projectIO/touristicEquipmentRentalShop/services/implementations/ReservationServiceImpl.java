package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.model.Reservation;
import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.repositories.ReservationRepository;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ReservationService;

public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl() {
        String persistenceUnitName = UserInSystem.getInstance().getUserType().getPersistenceUnitName();
        reservationRepository = new ReservationRepository(persistenceUnitName);
    }

    @Override
    public void makeReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
