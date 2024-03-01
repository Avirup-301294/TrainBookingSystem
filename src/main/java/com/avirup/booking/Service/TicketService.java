package com.avirup.booking.Service;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.Train;
import com.avirup.booking.Model.User;
import com.avirup.booking.Repository.TicketRepository;
import com.avirup.booking.Repository.TrainRepository;
import com.avirup.booking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainRepository trainRepository;


    public Ticket bookTicket(Ticket ticket) {
        User user = getUser(ticket);
        Train train = getTrain(ticket);
        ticket.setTrain(train);
        ticket.setUser(user);
        return ticketRepository.save(ticket);
    }

    private User getUser(Ticket ticket) {
        Long userId = ticket.getUser().getId();
        User user = userRepository.findAll()
                .stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);
        System.out.println(user);
        return user;
    }

    private Train getTrain(Ticket ticket) {
        Long trainId = ticket.getTrain().getId();
        Train train = trainRepository.findAll()
                .stream()
                .filter(t -> t.getId().equals(trainId))
                .findFirst()
                .orElse(null);
        System.out.println(train);
        return train;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicket(Long ticketId) {
        Ticket ticket = getAllTickets()
                .stream()
                .filter(t -> t.getId().equals(ticketId))
                .findFirst()
                .orElse(null);
        System.out.println(ticket);
        return ticket;
    }

    public void removeTicket(Long userId) {
        List<Ticket> tickets = getAllTickets();
        for(Ticket ticket: tickets) {
            if(ticket.getUser().getId().equals(userId)) {
                ticketRepository.deleteById(ticket.getId());
            }
        }
    }
}
