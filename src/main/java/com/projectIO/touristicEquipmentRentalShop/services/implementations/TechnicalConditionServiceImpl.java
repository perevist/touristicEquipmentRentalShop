package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.projectIO.touristicEquipmentRentalShop.dao.implementations.TechnicalConditionDAOImpl;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.TechnicalConditionDAO;
import com.projectIO.touristicEquipmentRentalShop.model.TechnicalCondition;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.TechnicalConditionService;

import java.util.List;

public class TechnicalConditionServiceImpl implements TechnicalConditionService {

    private TechnicalConditionDAO technicalConditionDAO;

    public TechnicalConditionServiceImpl() {
        technicalConditionDAO = new TechnicalConditionDAOImpl();
    }

    @Override
    public List<TechnicalCondition> getAllTechnicalConditions() {
        return technicalConditionDAO.readAll();
    }
}
