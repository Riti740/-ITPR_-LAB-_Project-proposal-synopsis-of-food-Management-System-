package com.jdbcconnectivity.FoodManagement.service.impl;

import com.jdbcconnectivity.FoodManagement.dao.ConsumptionDAO;
import com.jdbcconnectivity.FoodManagement.dao.FoodItemDAO;
import com.jdbcconnectivity.FoodManagement.dao.impl.ConsumptionDAOImpl;
import com.jdbcconnectivity.FoodManagement.dao.impl.FoodItemDAOImpl;
import com.jdbcconnectivity.FoodManagement.model.Consumption;
import com.jdbcconnectivity.FoodManagement.service.ConsumptionService;

public class ConsumptionServiceImpl implements ConsumptionService {

    private final ConsumptionDAO consumptionDAO = new ConsumptionDAOImpl();
    private final FoodItemDAO foodItemDAO = new FoodItemDAOImpl();

    @Override
    public void consumeFood(int foodId, int quantity) {
        Consumption c = new Consumption();
        c.setFoodItemId(foodId);
        c.setQuantity(quantity);

        consumptionDAO.save(c);
        foodItemDAO.updateQuantity(foodId, -quantity); // reduce stock
    }
}
