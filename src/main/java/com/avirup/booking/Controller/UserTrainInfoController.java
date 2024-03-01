package com.avirup.booking.Controller;

import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Service.UserTrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userTrainInfo")
public class UserTrainInfoController {

    @Autowired
    private UserTrainInfoService userTrainInfoService;

    @GetMapping
    public UserTrainInfo getUserTicketInfo(@RequestParam("id") Long id) {
        return userTrainInfoService.getUserTrainInfo(id);
    }

}
