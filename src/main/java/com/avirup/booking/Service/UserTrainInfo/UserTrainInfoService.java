package com.avirup.booking.Service.UserTrainInfo;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.UserTrainInfo;

public interface UserTrainInfoService {
    UserTrainInfo getUserTrainInfo(Long id);
    void removeUserTrainInfo(Long id);

}
