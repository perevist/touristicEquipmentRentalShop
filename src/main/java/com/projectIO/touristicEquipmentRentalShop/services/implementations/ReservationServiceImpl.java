package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.CustomerDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.implementations.ReservationDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.implementations.StatusDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.CustomerDAO;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ReservationDAO;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.StatusDAO;
import com.projectIO.touristicEquipmentRentalShop.model.*;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ReservationService;

import java.time.LocalDate;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private ReservationDAO reservationDAO;
    private StatusDAO statusDAO;
    private CustomerDAO customerDAO;

    public ReservationServiceImpl() {
        reservationDAO = new ReservationDAOImpl();
        statusDAO = new StatusDAOImpl();
        customerDAO = new CustomerDAOImpl();
    }

    @Override
    public void makeReservation(List<Item> items, LocalDate dateOfReceipt, int rentalLength) {
        validateParameters(items, dateOfReceipt, rentalLength);

        Status status = statusDAO.read(1); // status - do odebrania
        String loginOfCurrentUserInSystem = UserInSystem.getInstance().getLogin();
        Customer ownerOfReservation = customerDAO.read(loginOfCurrentUserInSystem);

        Reservation reservation = new Reservation(items, dateOfReceipt, rentalLength, status, ownerOfReservation);

        reservationDAO.save(reservation);
    }

    private void validateParameters(List<Item> items, LocalDate dateOfReceipt, int rentalLength) {
        if (items.isEmpty() || dateOfReceipt == null || rentalLength <= 0)
            throw new IllegalArgumentException("Przekazano nieprawidlowe dane");
    }

    @Override
    public List<Reservation> getAllReservationsOfCurrentlyLoggedUser() {
        String customerLogin = UserInSystem.getInstance().getLogin();
        return reservationDAO.getAllReservationsFilteredByCustomerLogin(customerLogin);
    }

    @Override
    public List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByDate(LocalDate dateOfReceipt) {
        String customerLogin = UserInSystem.getInstance().getLogin();
        return reservationDAO.getAllReservationsFilteredByCustomerLoginAndDate(customerLogin, dateOfReceipt);
    }

    @Override
    public List<Reservation> getAllReservationsOfCurrentlyLoggedUserFilteredByReservationNumber(int number) {
        String customerLogin = UserInSystem.getInstance().getLogin();
        return reservationDAO.getAllReservationsFilteredByCustomerLoginAndReservationNumber(customerLogin,
                number);
    }

    @Override
    public void cancelReservation(int id) {
        reservationDAO.delete(id);
    }
}
