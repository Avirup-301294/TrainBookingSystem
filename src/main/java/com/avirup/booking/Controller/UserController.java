package com.avirup.booking.Controller;

import com.avirup.booking.Model.User;
import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Service.TicketService;
import com.avirup.booking.Service.UserService;
import com.avirup.booking.Service.UserTrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserTrainInfoService userTrainInfoService;

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/remove/{userId}")
    public void removeUser(@PathVariable Long userId) {
        userTrainInfoService.removeUserTrainInfo(userId);
        ticketService.removeTicket(userId);
        userService.removeUser(userId);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
