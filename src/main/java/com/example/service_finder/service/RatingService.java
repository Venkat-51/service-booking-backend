package com.example.service_finder.service;

import com.example.service_finder.model.Booking;
import com.example.service_finder.model.Rating;
import com.example.service_finder.repository.BookingRepository;
import com.example.service_finder.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService  {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public String addRating(Rating rating) {

        Optional<Booking> bookingOptional = bookingRepository.findById(rating.getBooking().getId());

        if (bookingOptional.isEmpty()) {
            return "Booking not found";
        }

        Booking booking = bookingOptional.get();

        // Allow rating only after job completion
        if (!booking.getStatus().equals("COMPLETED")) {
            return "You can rate only after service completion";
        }

        ratingRepository.save(rating);

        return "Rating submitted successfully";
    }
}
