package com.example.springboot.redis.Service;

import com.example.springboot.redis.Model.User;
import java.util.List;

public interface UserService {

  boolean saveUser(User user);

  List<User> fetchAllUser();

  User fetchUserById(Long userId);

  boolean deleteUserByUserId(Long userId);
}
