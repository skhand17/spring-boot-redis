package com.example.springboot.redis.Repository;

import com.example.springboot.redis.Model.User;
import java.util.List;

public interface UserDao {

  boolean saveUser(User user);

  List<User> fetchUsers();

  User fetchUserById(Long userId);

  boolean deleteUserByUserId(Long userId);
}
