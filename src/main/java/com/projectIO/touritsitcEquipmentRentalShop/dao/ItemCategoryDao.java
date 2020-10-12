package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.ItemCategory;

public interface ItemCategoryDao {
    void save(ItemCategory itemCategory);
    ItemCategory read(Long id);
    void update(ItemCategory itemCategory);
    void delete(Long id);
    void cleanUp();
}
