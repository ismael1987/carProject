package com.sunny.exceptions;

/**
 * Created by Sunny on 8/11/2019.
 */
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException (Long id){
        super ("Could not find customer " + id);

    }
}
