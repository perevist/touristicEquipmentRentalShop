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

    @Override
    public List<ItemCategory> getAllCategories() {
        return itemCategoryDAO.readAll();
    }

    @Override
    public void addItemCategory(String name, double rentalCharge, double deposit) {
        if(name.isEmpty() || rentalCharge <= 0 || deposit <= 0){
            throw new IllegalArgumentException("Podano nieprawidłowe dane");
        }

        ItemCategory itemCategory = new ItemCategory(name, rentalCharge, deposit);

        try {
            itemCategoryDAO.save(itemCategory);
        } catch (Exception exception) {
            throw new IllegalArgumentException("Nazwa kategorii nie jest unikalna");
        }
    }

    @Override
    public void updateItemCategory(ItemCategory itemCategory) {
        itemCategoryDAO.update(itemCategory);
    }

    @Override
    public void removeItemCategory(int itemCategoryId) {
        itemCategoryDAO.delete(itemCategoryId);
    }
}
