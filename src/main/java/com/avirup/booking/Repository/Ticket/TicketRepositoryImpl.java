package com.avirup.booking.Repository.Ticket;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.Train;
import com.avirup.booking.Model.User;
import com.avirup.booking.Model.UserTrainInfo;
import com.avirup.booking.Repository.Train.TrainRepository;
import com.avirup.booking.Repository.User.UserRepository;
import com.avirup.booking.Repository.UserTrainInfo.UserTrainInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TicketRepositoryImpl implements TicketRepository{

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTrainInfoRepository userTrainInfoRepository;

    private final List<Ticket> ticketList = new ArrayList<>();
    private final Map<Integer, Ticket> ticketMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(999);

    @Override
    public Ticket save(Ticket ticket) {
        long newId = idCounter.incrementAndGet();
        ticket.setId(newId);
        ticketMap.put((int) newId, ticket);
        ticketList.add(ticket);
        return ticket;
    }

    @Override
    public Ticket bookTicket(Ticket ticket) {
        // Before ticket book, user and train should be non-null
        User user = userRepository.getUser(ticket.getUser().getId());
        Train train = trainRepository.getTrain(ticket.getTrain().getId());

        System.out.println(user);
        System.out.println(train);

        ticket.setTrain(train);
        ticket.setUser(user);
        save(ticket);

        List<Ticket> tickets = getAllTickets();

        for(Ticket t: tickets) {
            if(t.getUser().getId().equals(ticket.getUser().getId())) {
                userTrainInfoRepository.createUserTrainInfo(ticket);
            }
        }

        return ticket;
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        Ticket ticket = getAllTickets()
                .stream()
                .filter(t -> t.getId().equals(ticketId))
                .findFirst()
                .orElse(null);
        System.out.println(ticket);
        return ticket;
    }


    @Override
    public List<Ticket> getAllTickets() {
        return ticketList;
    }


    @Override
    public void removeTicket(Long userId) {
        for(Map.Entry<Integer, Ticket> entry: ticketMap.entrySet()) {
            if(entry.getValue().getUser().getId().equals(userId)) {
                ticketMap.remove(entry.getKey());
            }
        }

        int idx = 0;
        for(Ticket ticket: ticketList) {
            if(ticket.getUser().getId().equals(userId)) {
                ticketList.remove(idx);
            }
            idx++;
        }
    }

    @Override
    public Ticket updateUserSeat(Long ticketId, String modifiedSeatNumber) {
        Ticket ticket = getTicket(ticketId);
        ticket.getTrain().setSeatNumber(modifiedSeatNumber);
        userTrainInfoRepository.updateUserTrainInfo(ticketId, modifiedSeatNumber);
        return ticket;
    }
}
