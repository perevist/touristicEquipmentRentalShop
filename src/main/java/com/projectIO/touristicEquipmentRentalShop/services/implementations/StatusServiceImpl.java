package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.StatusDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.StatusDAO;
import com.projectIO.touristicEquipmentRentalShop.model.Status;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.StatusService;

import java.util.List;

public class StatusServiceImpl implements StatusService {

    private StatusDAO statusDAO;

    public StatusServiceImpl() {
        statusDAO = new StatusDAOImpl();
    }

    @Override
    public List<Status> getAllStatuses() {
        return statusDAO.readAll();
    }
}
