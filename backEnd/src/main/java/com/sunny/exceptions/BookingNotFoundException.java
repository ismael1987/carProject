package com.sunny.exceptions;

import com.sunny.model.Booking;

/**
 * Created by Sunny on 8/11/2019.
 */
public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException (Long id) {
        super ("Could not find booking " + id);
    }
}
