package com.jdbcconnectivity.FoodManagement.service;

import com.jdbcconnectivity.FoodManagement.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
}
