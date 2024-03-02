package com.avirup.booking.Model;

import jakarta.persistence.*;
import lombok.*;


@Data
public class Ticket {
    private Long id;
    private User user;
    private Train train;
    private String from;
    private String to;
    private double pricePaid;

    public Ticket(Long id, User user, Train train, String from, String to, double pricePaid) {
        this.id = id;
        this.user = user;
        this.train = train;
        this.from = from;
        this.to = to;
        this.pricePaid = pricePaid;
    }
}
