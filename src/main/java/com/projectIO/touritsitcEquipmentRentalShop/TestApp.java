package com.projectIO.touritsitcEquipmentRentalShop;

import com.projectIO.touritsitcEquipmentRentalShop.dao.*;
import com.projectIO.touritsitcEquipmentRentalShop.model.Customer;

public class TestApp {

    public static void main(String[] args) {

        // ----- ItemCategory CRUD test -----
        //Create:
//        ItemCategoryDao itemCategoryDao = new ItemCategoryDaoImpl();
/*        ItemCategory itemCategory = new ItemCategory("Namiot", 10,5);
        itemCategoryDao.save(itemCategory);*/

        // Update:
/*        ItemCategory itemCategory2 = new ItemCategory("Namiot", 18, 4);
        itemCategory2.setId(1);
        itemCategoryDao.update(itemCategory2);*/

        // Read:
/*        ItemCategory foundItemCategory = itemCategoryDao.read(1);
        System.out.println("Znaleziono: " + foundItemCategory);*/

        // Delete:
//        itemCategoryDao.delete(1);


        // ----- Item CRUD test -----
        // Create:
//        ItemDao itemDao = new ItemDaoImpl();
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
//        Item foundItem = itemDao.read(1);
//        System.out.println("Znaleziono: " + foundItem);

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
        //Create:
//        CustomerDao customerDao = new CustomerDaoImpl();
//        Customer customer = new Customer("boczek", "Marian", "Boczkowski", "487256366",
//                "boczek@gmail.com", "haslo");
//        customerDao.save(customer);

        // Update:
/*        Customer customer2 = new Customer("boczek", "Alekasander", "Boczkowski", "1111111111",
                "nowymail@gmail.com", "haslo");
        customerDao.update(customer2);*/

        // Read:
/*        Customer customerFromDb = customerDao.read("boczek");
        System.out.println(customerFromDb);*/

        // Delete:
//        customerDao.delete("boczek");

        // Dodanie dwoch takich samych loginow - czy blad:
/*        Customer customer1 = new Customer("boczek", "Marian", "Boczkowski", "487256366",
                "boczek@gmail.com", "haslo");
        Customer customer2 = new Customer("boczek", "Adam", "Boczkowski", "455234794",
                "boczek3423@gmail.com", "haslo");
        customerDao.save(customer1);
        customerDao.save(customer2);*/

    }
}
