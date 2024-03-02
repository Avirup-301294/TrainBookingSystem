package com.avirup.booking.Service.UserTrainInfo;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Repository.UserTrainInfo.UserTrainInfoRepository;
import com.avirup.booking.Service.Ticket.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTrainInfoServiceImpl implements UserTrainInfoService{
    @Autowired
    private UserTrainInfoRepository userTrainInfoRepository;

    @Override
    public UserTrainInfo getUserTrainInfo(Long id) {
        return userTrainInfoRepository.getUserTrainInfo(id);
    }

    @Override
    public void removeUserTrainInfo(Long id) {
        userTrainInfoRepository.removeUserTrainInfo(id);
    }

}
