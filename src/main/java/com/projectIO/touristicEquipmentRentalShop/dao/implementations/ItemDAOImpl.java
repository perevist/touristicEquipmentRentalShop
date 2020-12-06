package com.projectIO.touristicEquipmentRentalShop.dao.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.EntityManagerProvider;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ItemDAO;
import com.projectIO.touristicEquipmentRentalShop.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ItemDAOImpl extends GenericDAOImpl<Item, Integer> implements ItemDAO {

    public List<Item> getItemsFilteredByCategoryAndAvailabilityDate(int categoryId, LocalDate dateOfReceipt) {
        String date = dateOfReceipt.toString();
        String queryReservedItems = "SELECT r.items FROM Reservation r WHERE r.dateOfReceipt>='" + date + "' " +
                "AND (r.dateOfReceipt + r.rentalLength) >='" + date + "'";

        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();

        Query resultReservedItems = em.createQuery(queryReservedItems);
        List<Item> reservedItems = (List<Item>) resultReservedItems.getResultList();

        for (int i = 0; i < reservedItems.size(); i++) {
            if (reservedItems.get(i).getCategory().getId() != categoryId) {
                reservedItems.remove(i);
            }
        }

        String queryItemsWithConcreteCategory = "SELECT i FROM Item i WHERE i.category=" + categoryId
                + " AND i.isInCart=false AND i.technicalCondition=1";
        TypedQuery<Item> resultItemsWithConcreteCategory =
                em.createQuery(queryItemsWithConcreteCategory, Item.class);

        List<Item> itemsWithConcreteCategory = resultItemsWithConcreteCategory.getResultList();

        itemsWithConcreteCategory.removeAll(reservedItems);

        em.close();

        return itemsWithConcreteCategory;
    }
}
