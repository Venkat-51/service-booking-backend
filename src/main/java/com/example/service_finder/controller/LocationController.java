package com.example.service_finder.controller;

import com.example.service_finder.dto.LocationRequest;
import com.example.service_finder.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/update")
    public String updateLocation(@RequestBody LocationRequest request){
        return locationService.updateLocation(request);
    }
}
