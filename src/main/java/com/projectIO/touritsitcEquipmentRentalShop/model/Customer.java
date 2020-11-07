package com.projectIO.touritsitcEquipmentRentalShop.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer extends Person{

    @Column(name = "email")
    private String email;

    public Customer() {
    }

    public Customer(String login, String firstName, String lastName, String phoneNumber, String password,
                    String email) {
        super(login, firstName, lastName, phoneNumber, password);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "email='" + email + '\'' +
                '}';
    }

}
