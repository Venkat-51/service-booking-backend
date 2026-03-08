package com.example.service_finder.controller;

import com.example.service_finder.model.Rating;
import com.example.service_finder.model.Booking;
import com.example.service_finder.repository.RatingRepository;
import com.example.service_finder.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @PostMapping("/add")
    public String addRating(@RequestBody Rating rating) {

        Optional<Booking> bookingOptional = bookingRepository.findById(rating.getBooking().getId());

        if (bookingOptional.isEmpty()) {
            return "Booking not found";
        }

        Booking booking = bookingOptional.get();

        if (!booking.getStatus().equals("COMPLETED")) {
            return "You can rate only after job completion";
        }

        ratingRepository.save(rating);

        return "Rating submitted successfully";
    }
}