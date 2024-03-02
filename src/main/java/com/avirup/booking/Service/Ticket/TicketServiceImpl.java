package com.avirup.booking.Service.Ticket;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.Train;
import com.avirup.booking.Model.User;
import com.avirup.booking.Repository.Ticket.TicketRepository;
import com.avirup.booking.Repository.Train.TrainRepository;
import com.avirup.booking.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket bookTicket(Ticket ticket) {
        return ticketRepository.bookTicket(ticket);
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        return ticketRepository.getTicket(ticketId);
    }

    @Override
    public void removeTicket(Long userId) {
        ticketRepository.removeTicket(userId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.getAllTickets();
    }

    @Override
    public Ticket updateUserSeat(Long ticketId, String modifiedSeatNumber) {
        return ticketRepository.updateUserSeat(ticketId, modifiedSeatNumber);
    }
}
