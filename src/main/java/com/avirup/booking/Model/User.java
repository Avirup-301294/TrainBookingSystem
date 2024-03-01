package com.avirup.booking.Model;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User", schema = "train_db")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

}

