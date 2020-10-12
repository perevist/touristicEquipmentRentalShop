package com.projectIO.touritsitcEquipmentRentalShop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "technical_condition")
    private String technicalCondition;

    @Column(name = "availability")
    private String availability;

    @Column(name = "producer")
    private String producer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private ItemCategory itemCategory;

    public Item() {
    }

    public Item(String technicalCondition, String availability, String producer) {
        this.technicalCondition = technicalCondition;
        this.availability = availability;
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechnicalCondition() {
        return technicalCondition;
    }

    public void setTechnicalCondition(String technicalCondition) {
        this.technicalCondition = technicalCondition;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", technicalCondition='" + technicalCondition + '\'' +
                ", availability='" + availability + '\'' +
                ", producer='" + producer + '\'' +
                ", itemCategory=" + itemCategory +
                '}';
    }
}
