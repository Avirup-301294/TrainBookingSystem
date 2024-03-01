package com.avirup.booking.Controller;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public Ticket bookTicket(@RequestBody Ticket ticket) {
        return ticketService.bookTicket(ticket);
    }

    @GetMapping("/")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping
    public Ticket getTicket(@RequestParam(name="id", required = false) Long id) {
        return ticketService.getTicket(id);
    }
}
