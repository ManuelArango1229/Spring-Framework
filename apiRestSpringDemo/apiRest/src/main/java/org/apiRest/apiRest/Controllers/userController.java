package org.apiRest.apiRest.Controllers;

import java.net.URI;
import java.util.List;

import org.apiRest.apiRest.entities.Employees;
import org.apiRest.apiRest.repositories.EmployeesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class userController {
  private final EmployeesRepository repository;

  public userController(EmployeesRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/employees")
  public ResponseEntity<List<Employees>> getAllEmployees() {
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<Employees> getEmployee(@PathVariable int id) {
    return ResponseEntity.ok(repository.findById(id));
  }

  @PostMapping("/employees")
  public ResponseEntity<Employees> createEmployee(@RequestBody Employees employee, UriComponentsBuilder ucb) {
    Employees newEmployee = repository.save(employee);
    URI uriEmployee = ucb.path("/employees/{id}").buildAndExpand(newEmployee.getId()).toUri();
    return ResponseEntity.created(uriEmployee).build();
  }

  @PutMapping("/employees")
  public ResponseEntity<Employees> changeEmployee(@RequestBody Employees updateEmployee, UriComponentsBuilder ucb) {
    Employees employee = repository.findByName(updateEmployee.getName());

    if (employee != null) {
      employee.setName(updateEmployee.getName());
      employee.setRole(updateEmployee.getRole());
      return ResponseEntity.ok(repository.save(employee));
    } else {
      Employees newEmployee = repository.save(updateEmployee);
      URI uriEmployee = ucb.path("/employees/{id}").buildAndExpand(newEmployee.getId()).toUri();
      return ResponseEntity.created(uriEmployee).build();
    }

  }
}
