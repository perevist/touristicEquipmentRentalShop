package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.repositories.ItemCategoryRepository;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemCategoryService;

import java.util.List;

public class ItemCategoryServiceImpl implements ItemCategoryService {

    private ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryServiceImpl() {
        String persistenceUnitName = UserInSystem.getInstance().getUserType().getPersistenceUnitName();
        itemCategoryRepository = new ItemCategoryRepository(persistenceUnitName);
    }

    public List<ItemCategory> getAllCategories() {
        return itemCategoryRepository.getAllItemCategories();
    }
}
