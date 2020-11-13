package com.projectIO.touristicEquipmentRentalShop;

import com.projectIO.touristicEquipmentRentalShop.model.Customer;
import com.projectIO.touristicEquipmentRentalShop.model.Item;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import com.projectIO.touristicEquipmentRentalShop.model.Reservation;
import com.projectIO.touristicEquipmentRentalShop.repositories.*;

import java.time.LocalDate;
import java.util.List;

public class TestApp {

    public static void main(String[] args) {

        System.out.println("Start");

        // ----- ItemCategory CRUD test -----
        //Create:
        ItemCategoryRepository itemCategoryRepository = new ItemCategoryRepository();

//        ItemCategory itemCategory = new ItemCategory("Rower", 30,10);
//        itemCategoryRepository.save(itemCategory);

        // Update:
//        ItemCategory itemCategory2 = new ItemCategory("Rower", 27, 4);
//        itemCategory2.setId(7);
//        itemCategoryRepository.update(itemCategory2);

        // Read:
//        ItemCategory foundItemCategory = itemCategoryRepository.read(1);
//
        LocalDate date = LocalDate.of(2020, 5, 14);
        ItemRepository itemRepository = new ItemRepository();
        List<Item> items = itemRepository.getItemsFilteredByCategoryAndAvailabilityDate(1, date);
        System.out.println(items);



        // Delete:
//        itemCategoryRepository.delete(7);

//        List<ItemCategory> itemCategories = itemCategoryRepository.getAllItemCategories();
//        for (ItemCategory itemCategory : itemCategories) {
//            System.out.println("Znaleziona kategoira: " + itemCategory);
//        }

        // ----- Item CRUD test -----
//        ItemRepository itemRepository = new ItemRepository();

        // Read:
//        Item foundItem1 = itemRepository.read(1);
//        Item foundItem2 = itemRepository.read(2);
//        System.out.println("Znaleziono: " + foundItem1);
//        System.out.println("Znaleziono: " + foundItem2);
//        ItemCategory itemCategory1 = foundItem1.getCategory();
//        ItemCategory itemCategory2 = foundItem2.getCategory();
//        boolean result = itemCategory1 == itemCategory2;
//        System.out.println("Wynik porownania: " + result);

        // Delete:
//        itemRepository.remove(5);


//        // --------- Customer CRUD test --------
//        CustomerRepository customerRepository = new CustomerRepository();
//
//        //Create:
//        Customer customer = new Customer("dwarl2", "Adam", "Zenkowski", "487256366",
//                "haslo1","adam_zenkowski@gmail.com");
//        customerRepository.save(customer);

        // Update:
//        Customer customer2 = new Customer("zenek2", "Alekasander", "Zenkowski",
//                "1111111111", "haslo1", "adam_zenkowski@gmail.com");
//        customerRepository.update(customer2);

        // Read:
//        Customer customerFromDb = customerRepository.read("zenek2");
//        System.out.println(customerFromDb);

        // Delete:
//        customerRepository.delete("zenek2");

        // Dodanie dwoch takich samych loginow - czy blad:
//        Customer customer1 = new Customer("dwarl2", "Marian", "Dwarlski", "487256366",
//                "dwarl_marian@gmail.com", "haslo");
//        Customer customer2 = new Customer("dwarl2", "Adam", "Dwarlski", "455234794",
//                "dwarl_adam@gmail.com", "haslo");
//        customerRepository.save(customer1);
//        customerRepository.save(customer2);

        // --------- Reservation CRUD test --------
//        ReservationDao reservationDao = new ReservationDaoImpl();

        // Read:
//        Reservation reservation = reservationDao.read(1);
//        System.out.println(reservation);

        // Delete:
//        reservationDao.delete(3);
    }
}
