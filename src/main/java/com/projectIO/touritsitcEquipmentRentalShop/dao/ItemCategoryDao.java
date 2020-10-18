package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.ItemCategory;

public interface ItemCategoryDao {
    void save(ItemCategory itemCategory);
    ItemCategory read(Integer id);
    void update(ItemCategory itemCategory);
    void delete(Integer id);
    void cleanUp();
}
