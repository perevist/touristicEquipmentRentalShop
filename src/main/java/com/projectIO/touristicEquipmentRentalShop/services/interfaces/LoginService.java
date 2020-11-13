package com.projectIO.touristicEquipmentRentalShop.services.interfaces;

import com.projectIO.touristicEquipmentRentalShop.model.UserType;

public interface LoginService {

    void loginUser(String login, String password, UserType userType);

}
