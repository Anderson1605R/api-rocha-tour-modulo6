package br.com.rochadev.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rochadev.api.models.UserModel;
import br.com.rochadev.api.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<UserModel>> getAllUsers() {
    var allUsers = service.getAllUsers();
    return ResponseEntity.ok().body(allUsers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserModel> getUserById(@PathVariable("id") long id) {
    UserModel user = service.getUserById(id);
    return ResponseEntity.ok().body(user);
  }

  @PostMapping
  public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserModel user) {
    var newUser = service.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
  }
}