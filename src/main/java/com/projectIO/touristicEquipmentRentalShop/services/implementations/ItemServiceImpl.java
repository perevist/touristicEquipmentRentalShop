package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.repositories.ItemRepository;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.ItemService;

import java.time.LocalDate;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl() {
        String persistenceUnitName = UserInSystem.getInstance().getUserType().getPersistenceUnitName();
        itemRepository = new ItemRepository(persistenceUnitName);
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
