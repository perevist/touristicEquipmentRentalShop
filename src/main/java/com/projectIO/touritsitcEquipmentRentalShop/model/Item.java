package com.projectIO.touritsitcEquipmentRentalShop.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "technical_condition_id")
    private int technicalConditionId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTechnicalConditionId() {
        return technicalConditionId;
    }

    public void setTechnicalConditionId(int technicalConditionId) {
        this.technicalConditionId = technicalConditionId;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", technicalConditionId=" + technicalConditionId +
                ", category=" + category +
                '}';
    }
}
