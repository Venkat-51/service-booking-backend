package com.example.service_finder.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long technicianId;
    private Long serviceId;
    private String status;
    private double price;
    private String location;
    // REQUESTED
    // ACCEPTED
    // TRAVELLING
    // COMPLETED
}
