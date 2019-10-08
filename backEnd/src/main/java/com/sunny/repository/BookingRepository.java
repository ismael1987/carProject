package com.sunny.repository;

import com.sunny.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sunny on 8/11/2019.
 */

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
/*
* supports:
    Creating new instances
    Updating existing ones
    Deleting
    Finding (one, all, by simple or complex properties)
* */

}

