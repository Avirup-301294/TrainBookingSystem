package com.avirup.booking.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ticket", schema = "train_db")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    private Train train;

    @Column(name = "from_location")
    private String from;

    @Column(name = "to_location")
    private String to;

    @Column(name = "price_paid")
    private double pricePaid;
}
