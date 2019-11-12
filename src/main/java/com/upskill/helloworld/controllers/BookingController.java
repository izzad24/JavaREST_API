package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.upskill.helloworld.models.Booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookingController
 */
@RestController
public class BookingController {

    @GetMapping(value = "/booking")
    public Booking booking(){
        Booking booking = createBooking();
        return booking;
    }

    @GetMapping(value = "/booking/{id}")
    public Booking userVarName(@PathVariable("id") int id) {
        Booking x = new Booking();
        x.setId(id);
        return x;
    }

    @GetMapping(value = "/bookings")
    public List<Booking> bookings(){
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(createBooking());
        bookings.add(createBooking());
        bookings.add(createBooking());

        return bookings;
    }

    Booking createBooking(){
        Random random = new Random();
        Booking booking = new Booking();
        booking.setId(random.nextInt(100));
        booking.setPrice(150);
        booking.setBookingDate("2019-11-12");
        booking.setCheckIn("2019-11-12: 15:00");
        booking.setCheckOut("2019-11-14: 12:00");
        booking.setCreateAt("2019-11-12: 08:00");
        booking.setUpdateAt("2019-11-12: 08:00");
        return booking;
    }
}