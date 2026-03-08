package com.example.service_finder.repository;

import com.example.service_finder.model.TechnicianLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TechnicianLocationRepository
        extends JpaRepository<TechnicianLocation, Long> {

    TechnicianLocation findByTechnicianId(Long technicianId);

}


