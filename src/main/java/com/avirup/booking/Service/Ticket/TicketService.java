package com.avirup.booking.Service.Ticket;

import com.avirup.booking.Model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Ticket ticket);
    Ticket getTicket(Long ticketId);
    void removeTicket(Long userId);
    List<Ticket> getAllTickets();
    Ticket updateUserSeat(Long ticketId, String modifiedSeatNumber);
}
