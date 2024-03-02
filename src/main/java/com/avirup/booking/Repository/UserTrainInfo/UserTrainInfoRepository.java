package com.avirup.booking.Repository.UserTrainInfo;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.UserTrainInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTrainInfoRepository {
    void save(UserTrainInfo userTrainInfo);
    UserTrainInfo getUserTrainInfo(Long id);
    void removeUserTrainInfo(Long id);
    void createUserTrainInfo(Ticket ticket);
    void updateUserTrainInfo(Long id, String modifiedSeatNumber);
}
