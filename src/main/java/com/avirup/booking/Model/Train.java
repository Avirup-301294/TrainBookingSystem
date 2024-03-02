package com.avirup.booking.Model;

import jakarta.persistence.*;
import lombok.*;


@Data
public class Train {
    private Long id;
    private String section;
    private String seatNumber;
    public Train(Long id, String section, String seatNumber) {
        this.id = id;
        this.section = section;
        this.seatNumber = seatNumber;
    }
}

