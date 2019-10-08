package com.sunny.controller;

import com.sunny.exceptions.BookingNotFoundException;
import com.sunny.model.Booking;
import com.sunny.repository.BookingRepository;
import com.sunny.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sunny on 8/11/2019.
 */
public class BookingRestController {
    @Autowired
    BookingRepository bookingRepository;

    /**GET**/ //read all
    @RequestMapping(value="/bookings", method = RequestMethod.GET)
    public List getAllLocations()
    {
        return (List)bookingRepository.findAll();
    }

    /**GET**/ //read one
    @GetMapping("/v1/booking/{id}")
    Booking one (@PathVariable Long id){
        return bookingRepository.findById(id).orElseThrow(()-> new BookingNotFoundException(id));
    }

    /**POST**/ //create
    @PostMapping("/v1/booking")
    Booking newBooking(@RequestBody Booking newBooking) {
        return bookingRepository.save(newBooking);
    }

    /**PUT**/ //update
    @PutMapping("/v1/booking/{id}")//update return date and price
    Booking updateBooking (@RequestBody Booking newBooking, @PathVariable Long id) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setBooking_id(newBooking.getBooking_id());
                    //booking.setStart_date(newBooking.getStart_date());
                    //booking.setCustomer(newBooking.getCustomer());
                    //booking.setEnd_date(newBooking.getEnd_date());
                    booking.setReturn_date(newBooking.getReturn_date());
                    booking.setTotal_price(newBooking.getTotal_price());
                    return bookingRepository.save(booking);
                })
                .orElseGet(() -> {
                    newBooking.setBooking_id(id);
                    return bookingRepository.save(newBooking);

                });
    }

    /**TODO**/
    //calculate price



    /**DELETE**/
    @DeleteMapping("/booking/{id}")
    void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }
}



