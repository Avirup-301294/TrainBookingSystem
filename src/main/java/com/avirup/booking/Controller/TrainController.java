package com.avirup.booking.Controller;

import com.avirup.booking.Model.Train;
import com.avirup.booking.Service.Train.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public Train getTrain(@RequestParam("id") Long id) {
        return trainService.getTrain(id);
    }
    @PostMapping
    public Train createTrain(@RequestBody Train train) {
        return trainService.create(train);
    }
}
