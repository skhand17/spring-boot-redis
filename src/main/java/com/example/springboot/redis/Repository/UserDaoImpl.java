package com.example.springboot.redis.Repository;

import com.example.springboot.redis.Model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private RedisTemplate redisTemplate;

  private static final String KEY = "USER";

  @Override
  public boolean saveUser(User user) {
    try {
      redisTemplate.opsForHash().put(
          KEY, user.getId().toString(), user);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<User> fetchUsers() {
    return (List<User>) redisTemplate.opsForHash().values(KEY);
  }

  @Override
  public User fetchUserById(Long userId) {
    return (User) redisTemplate.opsForHash().get(KEY, userId.toString());
  }

  @Override
  public boolean deleteUserByUserId(Long userId) {

    try {
      redisTemplate.opsForHash().delete(KEY, userId.toString());
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
