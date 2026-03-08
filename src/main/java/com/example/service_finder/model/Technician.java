package com.example.service_finder.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="technicians")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String serviceType;

    private int experience;

    private double rating;

    private boolean verified;

    private double latitude;

    private double longitude;
}
