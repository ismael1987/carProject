package com.sunny.exceptions;

/**
 * Created by Sunny on 8/11/2019.
 */
public class LocationNotFoundException extends RuntimeException{

    public LocationNotFoundException (Long id){
        super("Could not find location " + id);
    }

}
