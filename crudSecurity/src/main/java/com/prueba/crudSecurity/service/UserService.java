package com.prueba.crudSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.crudSecurity.models.User;
import com.prueba.crudSecurity.repository.RoleRepository;
import com.prueba.crudSecurity.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User updateUser(Long id, User userDetails) {
    User user = userRepository.findById(id).orElseThrow();
    user.setName(userDetails.getName());
    user.setEmail(userDetails.getEmail());
    user.setPassword(userDetails.getPassword());
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
