package com.example.service_finder.dto;

import com.example.service_finder.model.Technician;

public class TechnicianDistanceDTO {

    private Technician technician;
    private double distance;

    public TechnicianDistanceDTO(Technician technician, double distance) {
        this.technician = technician;
        this.distance = distance;
    }

    public Technician getTechnician() {
        return technician;
    }

    public double getDistance() {
        return distance;
    }
}
