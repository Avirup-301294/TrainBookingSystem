package com.avirup.booking.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserTrainInfo {
    private Long ticketId;
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long trainId;
    private String section;
    private String seatNumber;
}
