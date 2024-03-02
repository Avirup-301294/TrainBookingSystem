package com.avirup.booking.Controller;

import com.avirup.booking.Model.User;
import com.avirup.booking.Service.Ticket.TicketService;
import com.avirup.booking.Service.User.UserService;
import com.avirup.booking.Service.UserTrainInfo.UserTrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserTrainInfoService userTrainInfoService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/remove/{userId}")
    public String removeUser(@PathVariable Long userId) {
        userTrainInfoService.removeUserTrainInfo(userId);
        ticketService.removeTicket(userId);
        return userService.removeUser(userId);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
