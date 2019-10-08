package com.sunny.controller;

import com.sunny.exceptions.LocationNotFoundException;
import com.sunny.model.Location;
import com.sunny.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sunny on 8/2/2019.
 */

@RestController
public class LocationRestController {
    @Autowired
    LocationRepository locationRepository;

    /**GET**/ //read all
    @RequestMapping(value="/locations", method = RequestMethod.GET)
    public List getAllLocations()
    {
        return (List)locationRepository.findAll();
    }

    /**GET**/ //read one
    @GetMapping("/v1/locations/{id}")
    Location one (@PathVariable Long id){
       return locationRepository.findById(id).orElseThrow(()-> new LocationNotFoundException(id));
    }

    /**POST**/ //create
    @PostMapping ("/v1/location")
        Location newLocation (@RequestBody Location newLocation) {
            return locationRepository.save((newLocation));
    }

    /**PUT**/ //update
    @PutMapping("/v1/locations/{id}")
    Location replaceLocation(@RequestBody Location newLocation, Long id){
        return locationRepository.findById(id)
                .map(location -> {
                  location.setLocation_id(newLocation.getLocation_id());
                  location.setCars_list(newLocation.getCars_list());
                  location.setCity(newLocation.getCity());
                  location.setLatitude(newLocation.getLatitude());
                  location.setLongitude(newLocation.getLongitude());
                  location.setStreet(newLocation.getStreet());
                  return locationRepository.save(location);
                })
                .orElseGet( () ->{
                    newLocation.setLocation_id(id);
                    return locationRepository.save(newLocation);
                });
    }

    /**DELETE**/
    @DeleteMapping("/location/{id}")
    void deleteLocation(@PathVariable Long id) {
        locationRepository.deleteById(id);
    }



}
