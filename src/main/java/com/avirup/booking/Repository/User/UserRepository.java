package com.avirup.booking.Repository.User;

import com.avirup.booking.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  {

    User createUser(User user);
    String deleteById(Long userId);
    User updateUser(User user);
    User getUser(Long id);
    List<User> findAll();

}
