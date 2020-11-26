package com.projectIO.touristicEquipmentRentalShop.dao.interfaces;

import java.util.List;

public interface GenericDAO<T, K> {
    void save(T entity);
    T read(K identifier);
    void update(T entity);
    void delete(K identifier);
    List<T> readAll();
}
