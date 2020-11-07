package com.projectIO.touritsitcEquipmentRentalShop.dao;

import com.projectIO.touritsitcEquipmentRentalShop.model.Item;
import com.projectIO.touritsitcEquipmentRentalShop.model.Reservation;

public interface ReservationDao {
    void save(Reservation reservation);
    Reservation read(int id);
    void update(Reservation reservation);
    void delete(int id);
    void cleanUp();
}
