package com.jdbcconnectivity.FoodManagement.service.impl;

import com.jdbcconnectivity.FoodManagement.dao.FoodItemDAO;
import com.jdbcconnectivity.FoodManagement.dao.PurchaseDAO;
import com.jdbcconnectivity.FoodManagement.dao.impl.FoodItemDAOImpl;
import com.jdbcconnectivity.FoodManagement.dao.impl.PurchaseDAOImpl;
import com.jdbcconnectivity.FoodManagement.model.Purchase;
import com.jdbcconnectivity.FoodManagement.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseDAO purchaseDAO = new PurchaseDAOImpl();
    private final FoodItemDAO foodItemDAO = new FoodItemDAOImpl();

    @Override
    public void purchaseFood(int foodId, int quantity) {
        Purchase purchase = new Purchase();
        purchase.setFoodItemId(foodId);
        purchase.setQuantity(quantity);

        purchaseDAO.save(purchase);
        foodItemDAO.updateQuantity(foodId, quantity); // increase stock
    }
}
