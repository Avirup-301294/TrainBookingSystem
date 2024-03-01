package com.avirup.booking.Service;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Repository.UserRepository;
import com.avirup.booking.Repository.UserTrainInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTrainInfoService {
    @Autowired
    private UserTrainInfoRepository userTrainInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketService ticketService;

    public UserTrainInfo getUserTrainInfo(Long id) {
        UserTrainInfo userTrainInfo = new UserTrainInfo();
        List<Ticket> tickets = ticketService.getAllTickets();

        for(Ticket ticket: tickets) {
            if(ticket.getUser().getId().equals(id)) {
                userTrainInfo.setUserId(ticket.getUser().getId());
                userTrainInfo.setFirstName(ticket.getUser().getFirstName());
                userTrainInfo.setLastName(ticket.getUser().getLastName());
                userTrainInfo.setEmail(ticket.getUser().getEmail());
                userTrainInfo.setTrainId(ticket.getTrain().getId());
                userTrainInfo.setSection(ticket.getTrain().getSection());
                userTrainInfo.setSeatNumber(ticket.getTrain().getSeatNumber());

                return userTrainInfoRepository.save(userTrainInfo);
            }
        }

        return null;
    }

    public void removeUserTrainInfo(Long id) {
        List<UserTrainInfo> userTrainInfos = userTrainInfoRepository.findAll();
        for(UserTrainInfo uti: userTrainInfos) {
            if(uti.getUserId().equals(id)) {
                userTrainInfoRepository.deleteById(uti.getId());
            }
        }
    }
}
