package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Item;

public interface ItemDao {
    void save(Item item);
    Item read(Long id);
    void update(Item item);
    void delete(Long id);
    void cleanUp();
}
