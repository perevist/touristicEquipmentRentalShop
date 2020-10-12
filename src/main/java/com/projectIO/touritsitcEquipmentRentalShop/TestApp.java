package com.projectIO.touritsitcEquipmentRentalShop;

import com.projectIO.touritsitcEquipmentRentalShop.dao.ItemCategoryDao;
import com.projectIO.touritsitcEquipmentRentalShop.dao.ItemCategoryDaoImpl;
import com.projectIO.touritsitcEquipmentRentalShop.dao.ItemDao;
import com.projectIO.touritsitcEquipmentRentalShop.dao.ItemDaoImpl;
import com.projectIO.touritsitcEquipmentRentalShop.model.Item;
import com.projectIO.touritsitcEquipmentRentalShop.model.ItemCategory;

public class TestApp {

    public static void main(String[] args) {

        // ----- ItemCategory CRUD test -----
        // Create:
//        ItemCategoryDao itemCategoryDao = new ItemCategoryDaoImpl();
//        ItemCategory itemCategory = new ItemCategory("Namiot", 10,5);
//        itemCategoryDao.save(itemCategory);

        // Update:
//        ItemCategory itemCategory2 = new ItemCategory("Namiot", 18, 4);
//        itemCategory2.setId(1L);
//        itemCategoryDao.update(itemCategory2);

        // Read:
//        ItemCategory foundItemCategory = itemCategoryDao.read(1L);
//        System.out.println("Znaleziono: " + foundItemCategory);

        // Delete:
//        itemCategoryDao.delete(1L);


        // ----- Item CRUD test -----
        // Create:
//        ItemDao itemDao = new ItemDaoImpl();
//        ItemCategory itemCategory2 = new ItemCategory("Plecak", 15, 2);
//        Item item = new Item("sprawny", "dostepny", "Nike");
//        item.setItemCategory(itemCategory2);
//        itemDao.save(item);

        // Update:
//        Item item2 = new Item("do naprawy", "dostepny", "Nike");
//        item2.setItemCategory(itemCategory2);
//        item2.setId(10L);
//        itemDao.update(item2);

        // Read:
//        Item foundItem = itemDao.get(10L);
//        System.out.println("Znaleziono: " + foundItem);

        // Delete:
//        itemDao.remove(10L);

        // ManyToOne relation test:
        // Czy zapisuje tylko jeden obiekt itemCategory3 w bazie danych:
//        ItemDao itemDao3 = new ItemDaoImpl();
//        ItemCategory itemCategory3 = new ItemCategory("Rower", 25, 10);
//        Item item3 = new Item("sprawny", "dostepny", "Kross");
//        item3.setItemCategory(itemCategory3);
//        Item item4 = new Item("sprawny", "niedostepny", "Biedronka");
//        item4.setItemCategory(itemCategory3);
//
//        itemDao3.save(item3);
//        itemDao3.save(item4);

        // Czy usuwa egzemplarze z tej samej kategorii:
//        ItemCategoryDao itemCategoryDao3 = new ItemCategoryDaoImpl();
//        itemCategoryDao3.delete(2L);

    }
}
