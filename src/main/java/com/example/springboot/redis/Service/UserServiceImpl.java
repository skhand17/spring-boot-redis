package com.example.springboot.redis.Service;

import com.example.springboot.redis.Model.User;
import com.example.springboot.redis.Repository.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;
  @Override
  public boolean saveUser(User user) {
    return userDao.saveUser(user);
  }

  @Override
  public List<User> fetchAllUser() {
    return userDao.fetchUsers();
  }

  @Override
  public User fetchUserById(Long userId) {
    return userDao.fetchUserById(userId);
  }

  @Override
  public boolean deleteUserByUserId(Long userId) {
    return userDao.deleteUserByUserId(userId);
  }
}
