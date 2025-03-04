package com.example.app;

import com.example.app.database.UserDAO;
import com.example.app.models.User;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    UserDAO repository = new UserDAO();
    User newUser = new User("juan", "juan@test.com");
    repository.createUser(newUser);
  }
}
