package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;

import com.upskill.helloworld.models.Booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookingController
 */
@RestController
public class BookingController {

    @GetMapping(value = "/booking")
    public List<Booking> booking(@RequestParam(name = "confirmed", required = false) Boolean confirmed){
        ArrayList<Booking> bookings = seedBooking();
        ArrayList<Booking> result = new ArrayList<>();
        for (Booking booking : bookings) {
            if(booking.getConfirmed() == true){
                result.add(booking);
            }
        }
        return result;
    }

    @GetMapping(value = "/booking/{confirmed}")
    public Booking showBooking(@PathVariable("confirmed") boolean confirmed) {
        Booking x = createBooking();;
        x.setConfirmed(confirmed);
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

    @PostMapping(value="/create_booking")
    public Booking create(@RequestBody Booking booking){
        Booking x = createBooking();
        x.setBookingDate(booking.getBookingDate());
        x.setConfirmed(booking.getConfirmed());
        return x;
    }

    Booking createBooking(){
        Booking booking = new Booking();
        booking.setPrice(150);
        booking.setBookingDate("2019-11-12");
        booking.setCheckIn("2019-11-12: 15:00");
        booking.setCheckOut("2019-11-14: 12:00");
        booking.setCreateAt("2019-11-12: 08:00");
        booking.setUpdateAt("2019-11-12: 08:00");
        booking.setConfirmed(false);
        return booking;
    }

    ArrayList<Booking> seedBooking(){
        ArrayList<Booking> bookings = new ArrayList<>();
        for(int id = 1; id < 11; id++){
            Booking booking = createBooking();
            booking.setId(id);
            bookings.add(booking);
        }

        bookings.get(0).setConfirmed(true);
        bookings.get(4).setConfirmed(true);
        bookings.get(7).setConfirmed(true);

        return bookings;
    }
}