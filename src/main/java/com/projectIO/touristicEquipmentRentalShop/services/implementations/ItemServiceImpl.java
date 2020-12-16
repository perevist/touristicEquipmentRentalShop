package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.ItemDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ItemDAO;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.model.TechnicalCondition;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemService;

import java.time.LocalDate;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemDAO itemDAO;

    public ItemServiceImpl() {
        itemDAO = new ItemDAOImpl();
    }

    @Override
    public List<Item> getItemsFilteredByCategoryAndAvailabilityDate(int categoryId, LocalDate dateOfReceipt) {
        return itemDAO.getItemsFilteredByCategoryAndAvailabilityDate(categoryId, dateOfReceipt);
    }

    @Override
    public void updateItem(Item item) {
        itemDAO.update(item);
    }

    @Override
    public void addItem(ItemCategory itemCategory, TechnicalCondition technicalCondition) {
        if(itemCategory == null || technicalCondition == null){
            throw new NullPointerException("Podano nieprwidlowe dane");
        }

        Item item = new Item();
        item.setCategory(itemCategory);
        item.setTechnicalCondition(technicalCondition);
        itemDAO.save(item);
    }

    @Override
    public void removeItem(int itemId) {
        itemDAO.delete(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDAO.readAll();
    }
}
