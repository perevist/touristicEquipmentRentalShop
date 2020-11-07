package com.projectIO.touritsitcEquipmentRentalShop;

import com.projectIO.touritsitcEquipmentRentalShop.dao.*;
import com.projectIO.touritsitcEquipmentRentalShop.model.Customer;
import com.projectIO.touritsitcEquipmentRentalShop.model.Item;
import com.projectIO.touritsitcEquipmentRentalShop.model.ItemCategory;

public class TestApp {

    public static void main(String[] args) {

        System.out.println("Start");

        // ----- ItemCategory CRUD test -----
        //Create:
//        ItemCategoryDao itemCategoryDao = new ItemCategoryDaoImpl();

//        ItemCategory itemCategory = new ItemCategory("Rower", 30,10);
//        itemCategoryDao.save(itemCategory);

        // Update:
//        ItemCategory itemCategory2 = new ItemCategory("Rower", 27, 4);
//        itemCategory2.setId(6);
//        itemCategoryDao.update(itemCategory2);

        // Read:
//        ItemCategory foundItemCategory = itemCategoryDao.read(6);
//        System.out.println("Znaleziono: " + foundItemCategory);

        // Delete:
//        itemCategoryDao.delete(6);


        // ----- Item CRUD test -----
        // Create:
        ItemDao itemDao = new ItemDaoImpl();

//        ItemCategory itemCategory2 = new ItemCategory("Plecak", 15, 2);
//        Item item = new Item("sprawny", "dostepny", "Nike");
//        item.setItemCategory(itemCategory2);
//        itemDao.save(item);

        // Update:
/*        Item item2 = new Item("do naprawy", "dostepny", "Nike");
        item2.setItemCategory(itemCategory2);
        item2.setId(1);
        itemDao.update(item2);*/

        // Read:
//        Item foundItem1 = itemDao.read(1);
//        Item foundItem2 = itemDao.read(2);
//        System.out.println("Znaleziono: " + foundItem1);
//        System.out.println("Znaleziono: " + foundItem2);
//        ItemCategory itemCategory1 = foundItem1.getCategory();
//        ItemCategory itemCategory2 = foundItem2.getCategory();
//        boolean result = itemCategory1 == itemCategory2;
//        System.out.println("Wynik porownania: " + result);


        // Delete:
//        itemDao.remove(1L);

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


        // --------- Customer CRUD test --------
//        CustomerDao customerDao = new CustomerDaoImpl();

        //Create:
//        Customer customer = new Customer("kruk2", "Marian", "Kruk", "487256366",
//                "marian_kruk@gmail.com", "haslo1");
//        customerDao.save(customer);

        // Update:
//        Customer customer2 = new Customer("kruk2", "Alekasander", "Kruk", "1111111111",
//                "marian_kruk@gmail.com", "haslo1");
//        customerDao.update(customer2);

        // Read:
//        Customer customerFromDb = customerDao.read("kruk2");
//        System.out.println(customerFromDb);

        // Delete:
//        customerDao.delete("kruk2");

        // Dodanie dwoch takich samych loginow - czy blad:
//        Customer customer1 = new Customer("dwarl2", "Marian", "Dwarlski", "487256366",
//                "dwarl_marian@gmail.com", "haslo");
//        Customer customer2 = new Customer("dwarl2", "Adam", "Dwarlski", "455234794",
//                "dwarl_adam@gmail.com", "haslo");
//        customerDao.save(customer1);
//        customerDao.save(customer2);

    }
}
