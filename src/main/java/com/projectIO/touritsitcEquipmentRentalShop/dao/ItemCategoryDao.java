package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.ItemCategory;

public interface ItemCategoryDao {
    void save(ItemCategory itemCategory);
    ItemCategory read(int id);
    void update(ItemCategory itemCategory);
    void delete(int id);
    void cleanUp();
}