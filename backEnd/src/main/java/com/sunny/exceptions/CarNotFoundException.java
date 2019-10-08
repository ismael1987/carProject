package com.sunny.exceptions;

/**
 * Created by Sunny on 7/29/2019.
 */
public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException (Long id){
        super("Could not find student " + id);
    }


}