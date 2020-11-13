package com.projectIO.touristicEquipmentRentalShop.repositories;

import com.projectIO.touristicEquipmentRentalShop.model.Item;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ItemRepository extends GenericRepository<Item, Integer> {

    public ItemRepository(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    public List<Item> getItemsFilteredByCategoryAndAvailabilityDate(int categoryId, LocalDate dateOfReceipt) {
        String date = dateOfReceipt.toString();
        String queryReservedItems = "SELECT r.items FROM Reservation r WHERE r.date>='" + date + "' " +
                "AND (r.date + r.rentalLength) >='" + date + "'";

        Query resultReservedItems = entityManager.createQuery(queryReservedItems);
        List<Item> reservedItems = (List<Item>) resultReservedItems.getResultList();

        for (int i = 0; i < reservedItems.size(); i++) {
            if (reservedItems.get(i).getCategory().getId() != categoryId) {
                reservedItems.remove(i);
            }
        }

        String queryItemsWithConcreteCategory = "SELECT i FROM Item i WHERE i.category=" + categoryId
                + " AND i.isInCart=false";
        TypedQuery<Item> resultItemsWithConcreteCategory =
                entityManager.createQuery(queryItemsWithConcreteCategory, Item.class);

        List<Item> itemsWithConcreteCategory = resultItemsWithConcreteCategory.getResultList();

        itemsWithConcreteCategory.removeAll(reservedItems);
        return itemsWithConcreteCategory;
    }
}
