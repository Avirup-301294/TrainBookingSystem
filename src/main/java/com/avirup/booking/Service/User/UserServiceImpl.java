package com.avirup.booking.Service.User;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.User;
import com.avirup.booking.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public User getUser(Ticket ticket) {
        return userRepository.getUser(ticket.getUser().getId());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String removeUser(Long userId) {
        return userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
