package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.model.*;
import com.projectIO.touristicEquipmentRentalShop.repositories.CustomerRepository;
import com.projectIO.touristicEquipmentRentalShop.repositories.ReservationRepository;
import com.projectIO.touristicEquipmentRentalShop.repositories.StatusRepository;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ReservationService;

import java.time.LocalDate;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    private StatusRepository statusRepository;
    private CustomerRepository customerRepository;

    public ReservationServiceImpl() {
        String persistenceUnitName = UserInSystem.getInstance().getUserType().getPersistenceUnitName();
        reservationRepository = new ReservationRepository(persistenceUnitName);
        statusRepository = new StatusRepository(persistenceUnitName);
        customerRepository = new CustomerRepository(persistenceUnitName);
    }

    @Override
    public void makeReservation(List<Item> items, LocalDate dateOfReceipt, int rentalLength) {
        validateParameters(items, dateOfReceipt, rentalLength);

        Status status = statusRepository.read(1); // status - do odebrania
        String loginOfCurrentUserInSystem = UserInSystem.getInstance().getLogin();
        Customer ownerOfReservation = customerRepository.read(loginOfCurrentUserInSystem);

        Reservation reservation = new Reservation(items, dateOfReceipt, rentalLength, status, ownerOfReservation);

        reservationRepository.save(reservation);
    }

    private void validateParameters(List<Item> items, LocalDate dateOfReceipt, int rentalLength) {
        if(items.isEmpty() || dateOfReceipt == null || rentalLength <= 0)
            throw new IllegalArgumentException("Przekazano nieprawidlowe dane");
    }

    @Override
    public List<Reservation> getAllReservationsOfCurrentlyLoggedUser(){
        String customerLogin = UserInSystem.getInstance().getLogin();
        return reservationRepository.getAllReservationsFilteredByCustomerLogin(customerLogin);
    }

    @Override
    public List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByDate(LocalDate dateOfReceipt){
        String customerLogin = UserInSystem.getInstance().getLogin();
        return reservationRepository.getAllReservationsFilteredByCustomerLoginAndDate(customerLogin, dateOfReceipt);
    }

    @Override
    public List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByReservationNumber(int number) {
        String customerLogin = UserInSystem.getInstance().getLogin();
        return reservationRepository.getAllReservationsFilteredByCustomerLoginAndReservationNumber(customerLogin,
                number);
    }

    @Override
    public void cancelReservation(int id) {
        reservationRepository.delete(id);
    }
}
