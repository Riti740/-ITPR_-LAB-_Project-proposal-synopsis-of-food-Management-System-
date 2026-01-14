package com.jdbcconnectivity.FoodManagement.service.impl;

import com.jdbcconnectivity.FoodManagement.dao.FoodItemDAO;
import com.jdbcconnectivity.FoodManagement.dao.impl.FoodItemDAOImpl;
import com.jdbcconnectivity.FoodManagement.model.FoodItem;
import com.jdbcconnectivity.FoodManagement.service.FoodItemService;

import java.util.List;

public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemDAO dao = new FoodItemDAOImpl();

    public void addFood(FoodItem item) {
        dao.save(item);
    }

    public List<FoodItem> getAllFood() {
        return dao.findAll();
    }

    public void updateQuantity(int id, int qty) {
        dao.updateQuantity(id, qty);
    }

    public List<FoodItem> getLowStock() {
        return dao.findLowStock();
    }
}
