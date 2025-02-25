package org.api.apiDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  @PostMapping("/login")
  public String login(
      @RequestParam String userName,
      @RequestParam String password,
      Model model) {

    if (!userName.isEmpty() && !password.isEmpty()) {
      model.addAttribute("user", userName);
    } else {
      model.addAttribute("errorMessage", "Invalid username or password");
      return "error";
    }
    return "dashboard";
  }
}
