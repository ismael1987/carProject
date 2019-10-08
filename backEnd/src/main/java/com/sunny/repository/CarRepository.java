package com.sunny.repository;

/**
 * Created by Sunny on 7/29/2019.
 */

import com.sunny.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository //solved re-occurring autowire error - bean not found
public interface CarRepository extends CrudRepository <Car, Long> {
/*
* supports:
    Creating new instances
    Updating existing ones
    Deleting
    Finding (one, all, by simple or complex properties)
* */

}