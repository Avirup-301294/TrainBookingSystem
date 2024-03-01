package com.avirup.booking.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "userTrainInfo", schema = "train_db")
@Data
public class UserTrainInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "train_id")
    private Long trainId;

    @Column(name = "section_number")
    private String section;

    @Column(name = "seat_number")
    private String seatNumber;
}
