package com.example.service_finder.repository;

import com.example.service_finder.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {

    List<Technician> findByServiceType(String serviceType);

}