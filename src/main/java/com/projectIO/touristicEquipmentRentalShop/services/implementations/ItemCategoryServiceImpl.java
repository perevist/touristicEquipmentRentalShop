package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.ItemCategoryDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ItemCategoryDAO;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemCategoryService;

import java.util.List;

public class ItemCategoryServiceImpl implements ItemCategoryService {

    private ItemCategoryDAO itemCategoryDAO;

    public ItemCategoryServiceImpl() {
        itemCategoryDAO = new ItemCategoryDAOImpl();
    }

    public List<ItemCategory> getAllCategories() {
        return itemCategoryDAO.readAll();
    }
}
