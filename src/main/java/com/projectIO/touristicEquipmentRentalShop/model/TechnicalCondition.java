package com.projectIO.touristicEquipmentRentalShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "technical_conditions")
public class TechnicalCondition {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

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

    @Override
    public String toString() {
        return "TechnicalCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
