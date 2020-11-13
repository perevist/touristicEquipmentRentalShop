package com.projectIO.touristicEquipmentRentalShop.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "technical_condition_id")
    private TechnicalCondition technicalCondition;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory category;
    @Column(name = "is_in_cart")
    boolean isInCart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TechnicalCondition getTechnicalCondition() {
        return technicalCondition;
    }

    public void setTechnicalCondition(TechnicalCondition technicalConditionId) {
        this.technicalCondition = technicalConditionId;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public boolean isInCart() {
        return isInCart;
    }

    public void setInCart(boolean inCart) {
        isInCart = inCart;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", technicalConditionId=" + technicalCondition +
                ", category=" + category +
                '}';
    }
}
