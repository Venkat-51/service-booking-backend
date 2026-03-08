package com.example.service_finder.service;

import com.example.service_finder.model.Booking;
import com.example.service_finder.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking){

        booking.setStatus("REQUESTED");

        return bookingRepository.save(booking);
    }

    public Booking acceptBooking(Long bookingId){

        Booking booking = bookingRepository.findById(bookingId).orElseThrow();

        booking.setStatus("ACCEPTED");

        return bookingRepository.save(booking);
    }

    public Booking startTravel(Long bookingId){

        Booking booking = bookingRepository.findById(bookingId).orElseThrow();

        booking.setStatus("TRAVELLING");

        return bookingRepository.save(booking);
    }

    public Booking completeBooking(Long bookingId){

        Booking booking = bookingRepository.findById(bookingId).orElseThrow();

        booking.setStatus("COMPLETED");

        return bookingRepository.save(booking);
    }
}
