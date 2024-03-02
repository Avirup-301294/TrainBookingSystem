package com.avirup.booking.Service.User;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    String removeUser(Long userId);
    User updateUser(User user);
    User getUser(Ticket ticket);
    List<User> getAllUsers();
}
