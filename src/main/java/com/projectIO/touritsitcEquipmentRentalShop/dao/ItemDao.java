package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Item;

public interface ItemDao {
    void save(Item item);
    Item read(int id);
    void update(Item item);
    void delete(int id);
    void cleanUp();
}
