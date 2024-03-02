package com.avirup.booking.Repository.Ticket;

import com.avirup.booking.Model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository {
    Ticket bookTicket(Ticket ticket);
    Ticket save(Ticket ticket);
    Ticket getTicket(Long ticketId);
    List<Ticket> getAllTickets();
    void removeTicket(Long userId);

    Ticket updateUserSeat(Long ticketId, String modifiedSeatNumber);

}
