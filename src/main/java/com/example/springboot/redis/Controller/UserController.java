package com.example.springboot.redis.Controller;

import com.example.springboot.redis.Model.User;
import com.example.springboot.redis.Service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;


  @PostMapping("/user")
  public ResponseEntity<String> saveUser(@RequestBody User user) {

    boolean result = userService.saveUser(user);
    if (result) {
      return ResponseEntity.ok("User Created Successfully");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @GetMapping("/user")
  public ResponseEntity<List<User>> fetchAllUser() {

    List<User> userList = userService.fetchAllUser();
    return ResponseEntity.ok(userList);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<User> fetchUserById(@PathVariable("userId") Long userId) {

    User user = userService.fetchUserById(userId);
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/user/{userId}")
  public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId) {

    boolean result = userService.deleteUserByUserId(userId);

    if (result) {
      return ResponseEntity.ok("User Deleted Successfully");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }
}
