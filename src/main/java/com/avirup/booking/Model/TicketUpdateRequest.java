package com.avirup.booking.Model;

import lombok.Data;

@Data
public class TicketUpdateRequest {
    private Long ticketId;
    private String modifiedSeatNumber;
}