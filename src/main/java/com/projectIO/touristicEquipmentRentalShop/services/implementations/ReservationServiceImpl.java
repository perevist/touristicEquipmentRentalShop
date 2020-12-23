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
import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private ReservationDAO reservationDAO;
    private StatusDAO statusDAO;
    private CustomerDAO customerDAO;

    public ReservationServiceImpl(ReservationDAO reservationDAO, StatusDAO statusDAO, CustomerDAO customerDAO) {
        this.reservationDAO = reservationDAO;
        this.statusDAO = statusDAO;
        this.customerDAO = customerDAO;
    }

    @Override
    public void makeReservation(List<Item> items, LocalDate dateOfReceipt, int rentalLength) {
        validateParameters(items, dateOfReceipt, rentalLength);

        Status status = statusDAO.read(1); // status - do odebrania
        String loginOfCurrentUserInSystem = UserInSystem.getInstance().getLogin();
        Customer ownerOfReservation = customerDAO.read(loginOfCurrentUserInSystem);

        Reservation reservation = new Reservation(items, dateOfReceipt, rentalLength, status, ownerOfReservation);
        reservationDAO.save(reservation);

        // wysyłanie na e-mail'a informacji o nowej rezerwacji
        // (funkcjonalność dodatkowa, realizowana w ramach kursu BD2)
        Thread thread = new Thread(() -> {
            SendMailServiceImpl.sendEmail(setEmailDetails(reservation));
        });
        thread.start();
    }

    private void validateParameters(List<Item> items, LocalDate dateOfReceipt, int rentalLength) {
        if (items.isEmpty() || dateOfReceipt == null || rentalLength <= 0)
            throw new IllegalArgumentException("Przekazano nieprawidlowe dane");
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDAO.readAll();
    }

    @Override
    public List<Reservation> getAllReservationsFilteredByDate(LocalDate dateOfReceipt) {
        return reservationDAO.getAllReservationsFilteredByDate(dateOfReceipt);
    }

    @Override
    public List<Reservation> getAllReservationsFilteredByReservationNumber(int number) {
        return reservationDAO.getAllReservationsFilteredByReservationNumber(number);
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

    @Override
    public void changeStatus(int reservationId, Status status) {
        Reservation reservation = reservationDAO.read(reservationId);
        reservation.setStatus(status);
        reservationDAO.update(reservation);
    }


    private List<String> setEmailDetails(Reservation reservation) {
        String subject = "Właśnie zarezerwowałeś/aś przedmioty w naszej wypożyczalni!";
        String email = reservation.getCustomer().getEmail();
        String newline = "\r\n";
        String message = "Witaj " + reservation.getCustomer().getFirstName()+ "!" + newline + newline +
                "   ----    Poniżej możesz zobaczyć szczegóły Twojego zamówienia    ----" + newline +
                "Numer zamówienia (do podania przy odbiorze): " + reservation.getId() + newline +
                "Data odebrania zamówienia: " + reservation.getDateOfReceipt() + newline +
                "Długość wypożyczenia: " + reservation.getRentalLength()  + " dni" + newline +
                "Obecny status rezerwacji: " + reservation.getStatus().getName()  + newline +
                "Osoba składająca rezerwację: " + reservation.getCustomer().getFirstName() + " " +
                reservation.getCustomer().getLastName() + " (login: "+ reservation.getCustomer().getLogin() + ")" +
                newline + newline + "Pozdrawiamy," + newline + "Twoja wypożyczalnia ;-) ";
        List<String> details = new ArrayList<String>();
        details.add(subject);
        details.add(email);
        details.add(message);

        return details;
    }
}
