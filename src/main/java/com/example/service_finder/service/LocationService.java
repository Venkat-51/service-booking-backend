package com.example.service_finder.service;

import com.example.service_finder.dto.LocationRequest;
import com.example.service_finder.model.Technician;
import com.example.service_finder.model.TechnicianLocation;
import com.example.service_finder.repository.TechnicianLocationRepository;
import com.example.service_finder.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private TechnicianLocationRepository locationRepository;

    public String updateLocation(LocationRequest request){

        Technician technician = technicianRepository
                .findById(request.getTechnicianId())
                .orElseThrow(() -> new RuntimeException("Technician not found"));

        TechnicianLocation location =
                locationRepository.findByTechnicianId(request.getTechnicianId());

        if(location == null){
            location = new TechnicianLocation();
            location.setTechnician(technician);
        }

        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());

        locationRepository.save(location);

        return "Location updated";
    }
}