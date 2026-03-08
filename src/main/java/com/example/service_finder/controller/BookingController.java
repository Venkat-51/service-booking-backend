package com.example.service_finder.controller;

import com.example.service_finder.model.Booking;
import com.example.service_finder.service.BookingService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking bookService(@RequestBody Booking booking){

        return bookingService.createBooking(booking);
    }

    @PostMapping("/accept/{id}")
    public Booking acceptBooking(@PathVariable Long id){

        return bookingService.acceptBooking(id);
    }

    @PostMapping("/travel/{id}")
    public Booking startTravel(@PathVariable Long id){

        return bookingService.startTravel(id);
    }

    @PostMapping("/complete/{id}")
    public Booking completeBooking(@PathVariable Long id){

        return bookingService.completeBooking(id);
    }

}