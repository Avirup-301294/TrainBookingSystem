package com.avirup.booking.Model;

public class TicketUpdateRequest {
    private Long ticketId;
    private String modifiedSeatNumber;

    // Getters and setters for the fields
    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getModifiedSeatNumber() {
        return modifiedSeatNumber;
    }

    public void setModifiedSeatNumber(String modifiedSeatNumber) {
        this.modifiedSeatNumber = modifiedSeatNumber;
    }
}