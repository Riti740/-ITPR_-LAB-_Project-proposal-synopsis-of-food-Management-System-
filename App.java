package com.jdbcconnectivity.FoodManagement;

import com.jdbcconnectivity.FoodManagement.model.FoodItem;
import com.jdbcconnectivity.FoodManagement.model.User;
import com.jdbcconnectivity.FoodManagement.service.FoodItemService;
import com.jdbcconnectivity.FoodManagement.service.UserService;
import com.jdbcconnectivity.FoodManagement.service.impl.FoodItemServiceImpl;
import com.jdbcconnectivity.FoodManagement.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static FoodItemService foodService = new FoodItemServiceImpl();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Add Food");
            System.out.println("4. View Food");
            System.out.println("5. Update Food Quantity");
            System.out.println("6. View Low Stock");
            System.out.println("7. Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter role: ");
                    String role = sc.nextLine();

                    User u = new User();
                    u.setName(name);
                    u.setRole(role);
                    userService.addUser(u);
                    System.out.println("User added");
                    break;

                case 2:
                    List<User> users = userService.getUsers();
                    for (User usr : users) {
                        System.out.println(
                                usr.getId() + " " +
                                usr.getName() + " " +
                                usr.getRole()
                        );
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Food name: ");
                    String foodName = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    FoodItem f = new FoodItem();
                    f.setName(foodName);
                    f.setQuantity(qty);
                    foodService.addFood(f);
                    System.out.println("Food added");
                    break;

                case 4:
                    List<FoodItem> foods = foodService.getAllFood();
                    for (FoodItem fi : foods) {
                        System.out.println(
                                fi.getId() + " " +
                                fi.getName() + " " +
                                fi.getQuantity()
                        );
                    }
                    break;

                case 5:
                    System.out.print("Food ID: ");
                    int id = sc.nextInt();
                    System.out.print("Quantity (+/-): ");
                    int q = sc.nextInt();
                    foodService.updateQuantity(id, q);
                    System.out.println("Quantity updated");
                    break;

                case 6:
                    List<FoodItem> lowStock = foodService.getLowStock();
                    for (FoodItem item : lowStock) {
                        System.out.println(
                                "LOW STOCK → " +
                                item.getName() + " : " +
                                item.getQuantity()
                        );
                    }
                    break;

                case 7:
                    System.out.println("Application exited");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
