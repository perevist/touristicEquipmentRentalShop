package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.model.TechnicalCondition;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    List<Item> getItemsFilteredByCategoryAndAvailabilityDate(int categoryId, LocalDate dateOfReceipt);
    void updateItem(Item item);
    void addItem(ItemCategory itemCategory, TechnicalCondition technicalCondition);
    void removeItem(int itemId);
    List<Item> getAllItems();
}
