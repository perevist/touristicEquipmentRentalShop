package com.projectIO.touristicEquipmentRentalShop.services;

import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.repositories.ItemRepository;

import java.time.LocalDate;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl() {
        itemRepository = new ItemRepository();
    }

    @Override
    public List<Item> getItemsFilteredByCategoryAndAvailabilityDate(int categoryId, LocalDate dateOfReceipt) {
        return itemRepository.getItemsFilteredByCategoryAndAvailabilityDate(categoryId, dateOfReceipt);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.update(item);
    }
}
