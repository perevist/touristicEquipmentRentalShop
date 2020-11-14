package com.projectIO.touristicEquipmentRentalShop.repositories;

import com.projectIO.touristicEquipmentRentalShop.model.Status;

public class StatusRepository extends GenericRepository<Status, Integer> {
    public StatusRepository(String persistenceUnitName) {
        super(persistenceUnitName);
    }
}
