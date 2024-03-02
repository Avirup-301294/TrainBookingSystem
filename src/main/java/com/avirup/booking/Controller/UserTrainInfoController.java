package com.avirup.booking.Controller;

import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Service.UserTrainInfo.UserTrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userTrainInfo")
public class UserTrainInfoController {

    @Autowired
    private UserTrainInfoService userTrainInfoService;

    @GetMapping
    public UserTrainInfo getUserTicketInfo(@RequestParam("id") Long id) {
        return userTrainInfoService.getUserTrainInfo(id);
    }

    @DeleteMapping
    public void removeUserTrainInfo(@RequestParam("id") Long id) {
        userTrainInfoService.removeUserTrainInfo(id);
    }

}
