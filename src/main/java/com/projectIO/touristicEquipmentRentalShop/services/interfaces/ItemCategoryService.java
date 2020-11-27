package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    List<ItemCategory> getAllCategories();
    void addItemCategory(String name, double rentalCharge, double deposit);
}
