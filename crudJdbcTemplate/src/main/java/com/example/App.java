package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.database.UserDAO;
import com.example.database.jdbcConfig;
import com.example.models.User;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
    UserDAO userDAO = context.getBean(UserDAO.class);
    User newUser = new User("JohnDoe", "johndoe@example.com");
    userDAO.createUser(newUser);

    User user = userDAO.getUserById(1);
    System.out.println(user);

  }
}
