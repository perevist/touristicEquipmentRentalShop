package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.ItemDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ItemDAO;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
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
}
