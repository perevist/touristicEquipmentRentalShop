package com.projectIO.touritsitcEquipmentRentalShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class ItemCategory {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "rental_charge")
    private double rentalCharge;
    @Column(name = "deposit")
    private double deposit;

    public ItemCategory() {
    }

    public ItemCategory(String name, double rentalCharge, double deposit) {
        this.name = name;
        this.rentalCharge = rentalCharge;
        this.deposit = deposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentalCharge() {
        return rentalCharge;
    }

    public void setRentalCharge(double rentalCharge) {
        this.rentalCharge = rentalCharge;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rentalCharge=" + rentalCharge +
                ", deposit=" + deposit +
                '}';
    }
}
