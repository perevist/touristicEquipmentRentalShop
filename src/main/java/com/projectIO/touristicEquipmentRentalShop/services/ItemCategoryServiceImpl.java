package com.projectIO.touristicEquipmentRentalShop.services;

import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.repositories.ItemCategoryRepository;

import java.util.List;

public class ItemCategoryServiceImpl implements ItemCategoryService {

    private ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryServiceImpl() {
        itemCategoryRepository = new ItemCategoryRepository();
    }

    public List<ItemCategory> getAllCategories() {
        return itemCategoryRepository.getAllItemCategories();
    }
}
