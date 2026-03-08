package com.example.service_finder.controller;

import com.example.service_finder.model.Technician;
import com.example.service_finder.repository.TechnicianRepository;
import com.example.service_finder.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    private final TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @PostMapping("/add")
    public Technician addTechnician(@RequestBody Technician technician){
        return technicianService.saveTechnician(technician);
    }

    @Autowired
    private TechnicianRepository technicianRepository;

    @GetMapping
    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();

    }
}
