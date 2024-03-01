package com.avirup.booking.Service;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.User;
import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Repository.TicketRepository;
import com.avirup.booking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketService ticketService;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
