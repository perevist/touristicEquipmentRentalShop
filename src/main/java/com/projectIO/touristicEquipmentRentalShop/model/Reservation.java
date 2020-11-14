package com.projectIO.touristicEquipmentRentalShop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_login")
    private Customer customer;
    @Column(name = "date_of_receipt")
    private LocalDate dateOfReceipt;
    @Column(name = "rental_length")
    private int rentalLength;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "reserved_items",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    List<Item> items;

    public Reservation(List<Item> items, LocalDate dateOfReceipt, int rentalLength, Status status, Customer ownerOfReservation) {
        this.items = items;
        this.dateOfReceipt = dateOfReceipt;
        this.customer = ownerOfReservation;
        this.rentalLength = rentalLength;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(LocalDate date) {
        this.dateOfReceipt = date;
    }

    public int getRentalLength() {
        return rentalLength;
    }

    public void setRentalLength(int rentalLength) {
        this.rentalLength = rentalLength;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customer=" + customer +
                ", dateOfReceipt=" + dateOfReceipt +
                ", rentalLength=" + rentalLength +
                ", status=" + status +
                ", items=" + items +
                '}';
    }
}
