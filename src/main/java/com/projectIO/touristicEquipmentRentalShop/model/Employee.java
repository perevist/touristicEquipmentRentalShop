package com.projectIO.touristicEquipmentRentalShop.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends Person {

    @Column(name = "salary")
    private double salary;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee() {
    }

    public Employee(String login, String firstName, String lastName, String phoneNumber, String password,
                    double salary, Position position) {
        super(login, firstName, lastName, phoneNumber, password);
        this.salary = salary;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", position=" + position +
                '}';
    }
}
