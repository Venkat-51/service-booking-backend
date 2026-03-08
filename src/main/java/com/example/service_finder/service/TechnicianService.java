package com.example.service_finder.service;


import com.example.service_finder.model.Technician;
import com.example.service_finder.repository.TechnicianRepository;
import org.springframework.stereotype.Service;
import com.example.service_finder.dto.TechnicianDistanceDTO;
import java.util.Comparator;

import java.util.List;
import java.util.ArrayList;

@Service
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

    public TechnicianService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    public List<Technician> findTechnicians(String serviceType) {

        return technicianRepository.findByServiceType(serviceType);
    }
    public double calculateDistance(double lat1,double lon1,double lat2,double lon2){

        double latDiff = lat1 - lat2;
        double lonDiff = lon1 - lon2;

        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }

    public Technician saveTechnician(Technician technician){
        return technicianRepository.save(technician);
    }

    // Find nearby technicians
    public List<Technician> findNearbyTechnicians(double userLat,double userLon){

        List<Technician> technicians = technicianRepository.findAll();
        List<Technician> nearby = new ArrayList<>();

        for(Technician tech : technicians){

            double distance = calculateDistance(
                    userLat,
                    userLon,
                    tech.getLatitude(),
                    tech.getLongitude()
            );

            if(distance <= 5){
                nearby.add(tech);
            }
        }
        // Sort technicians by distance
        nearby.sort(Comparator.comparingDouble(
                tech -> calculateDistance(userLat, userLon, tech.getLatitude(), tech.getLongitude())
        ));

        return nearby;

    }
}