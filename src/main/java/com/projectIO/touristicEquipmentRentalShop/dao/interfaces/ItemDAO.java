package com.projectIO.touristicEquipmentRentalShop.dao.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemDAO extends GenericDAO<Item, Integer> {

    List<Item> getItemsFilteredByCategoryAndAvailabilityDate(int categoryId, LocalDate dateOfReceipt);
}
