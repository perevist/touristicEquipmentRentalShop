package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Item;

public interface ItemDao {
    void save(Item item);
    Item read(Integer id);
    void update(Item item);
    void delete(Integer id);
    void cleanUp();
}
