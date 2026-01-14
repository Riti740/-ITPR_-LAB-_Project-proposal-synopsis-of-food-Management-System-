package com.jdbcconnectivity.FoodManagement.service.impl;

import com.jdbcconnectivity.FoodManagement.dao.UserDAO;
import com.jdbcconnectivity.FoodManagement.dao.impl.UserDAOImpl;
import com.jdbcconnectivity.FoodManagement.model.User;
import com.jdbcconnectivity.FoodManagement.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO dao = new UserDAOImpl();

    public void addUser(User user) {
        dao.save(user);
    }

    public List<User> getUsers() {
        return dao.findAll();
    }
}
