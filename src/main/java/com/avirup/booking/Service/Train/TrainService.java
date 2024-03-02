package com.avirup.booking.Service.Train;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.Train;

public interface TrainService {
    Train create(Train train);
    Train getTrain(Long id);
}
