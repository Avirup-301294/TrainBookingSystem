package com.avirup.booking.Repository.UserTrainInfo;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Repository.Ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserTrainInfoRepositoryImpl implements UserTrainInfoRepository{

    private final Map<Integer, UserTrainInfo> userTrainInfoMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(999);

    @Override
    public void save(UserTrainInfo userTrainInfo) {
        long newId = idCounter.incrementAndGet();
        userTrainInfoMap.put((int) newId, userTrainInfo);
    }

    @Override
    public void createUserTrainInfo(Ticket ticket) {
        UserTrainInfo userTrainInfo = new UserTrainInfo();
        userTrainInfo.setTicketId(ticket.getId());
        userTrainInfo.setUserId(ticket.getUser().getId());
        userTrainInfo.setFirstName(ticket.getUser().getFirstName());
        userTrainInfo.setLastName(ticket.getUser().getLastName());
        userTrainInfo.setEmail(ticket.getUser().getEmail());
        userTrainInfo.setTrainId(ticket.getTrain().getId());
        userTrainInfo.setSection(ticket.getTrain().getSection());
        userTrainInfo.setSeatNumber(ticket.getTrain().getSeatNumber());
        save(userTrainInfo);
        System.out.println(userTrainInfo);

    }

    @Override
    public UserTrainInfo getUserTrainInfo(Long id) {
        System.out.println(userTrainInfoMap);
        for(Map.Entry<Integer, UserTrainInfo> entry: userTrainInfoMap.entrySet()) {
            if(entry.getValue().getUserId().equals(id)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void removeUserTrainInfo(Long id) {
        for(Map.Entry<Integer, UserTrainInfo> entry: userTrainInfoMap.entrySet()) {
            if(entry.getValue().getUserId().equals(id)) {
                userTrainInfoMap.remove(entry.getKey());
            }
        }
    }
    @Override
    public void updateUserTrainInfo(Long id, String modifiedSeatNumber) {
        for(Map.Entry<Integer, UserTrainInfo> entry: userTrainInfoMap.entrySet()) {
            if(entry.getValue().getTicketId().equals(id)) {
                UserTrainInfo userTrainInfo = entry.getValue();
                userTrainInfo.setSeatNumber(modifiedSeatNumber);
                userTrainInfoMap.put(entry.getKey(), userTrainInfo);
            }
        }
    }
}
