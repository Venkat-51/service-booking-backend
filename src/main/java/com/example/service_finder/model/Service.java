package com.example.service_finder.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private double basePrice;
}
