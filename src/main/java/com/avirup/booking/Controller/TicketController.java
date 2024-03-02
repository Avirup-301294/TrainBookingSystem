package com.avirup.booking.Controller;

import com.avirup.booking.Model.Ticket;
import com.avirup.booking.Model.TicketUpdateRequest;
import com.avirup.booking.Service.Ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public Ticket bookTicket(@RequestBody Ticket ticket) {
        return ticketService.bookTicket(ticket);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping
    public Ticket getTicket(@RequestParam(name="id", required = false) Long id) {
        return ticketService.getTicket(id);
    }

//    @PutMapping("/updateUserSeat")
//    public Ticket updateUserSeat(@RequestBody Map<Long,String> map) {
//        Long ticketId = 0L;
//        String modifiedSeatNumber = null;
//        for(Map.Entry<Long, String> entry: map.entrySet()) {
//            ticketId = entry.getKey();
//            modifiedSeatNumber = entry.getValue();
//        }
//        return ticketService.updateUserSeat(ticketId, modifiedSeatNumber);
//    }
    @PutMapping("/updateUserSeat")
    public Ticket updateUserSeat(@RequestBody TicketUpdateRequest ticketUpdateRequest) {
        return ticketService.updateUserSeat(ticketUpdateRequest.getTicketId(), ticketUpdateRequest.getModifiedSeatNumber());
    }
}
