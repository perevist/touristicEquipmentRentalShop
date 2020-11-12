package com.projectIO.touristicEquipmentRentalShop.repositories;

import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;

import javax.persistence.TypedQuery;
import java.util.List;

public class ItemCategoryRepository extends GenericRepository<ItemCategory, Integer> {

    public List<ItemCategory> getAllItemCategories(){
        TypedQuery<ItemCategory> query = entityManager.createQuery("SELECT i FROM ItemCategory i", ItemCategory.class);
        List<ItemCategory> itemCategories = query.getResultList();
        return itemCategories;
    }
}
