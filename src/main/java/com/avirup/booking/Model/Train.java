package com.avirup.booking.Model;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Train", schema = "train_db")
@Data
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "section_no")
    private String section;

    @Column(name = "seat_number")
    private String seatNumber;
}

