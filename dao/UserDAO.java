package com.jdbcconnectivity.FoodManagement.dao;

import com.jdbcconnectivity.FoodManagement.model.User;
import java.util.List;

public interface UserDAO {
    void save(User user);
    List<User> findAll();
}
