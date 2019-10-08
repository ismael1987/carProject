package com.sunny.repository;

/**
 * Created by Sunny on 8/2/2019.
 */

import com.sunny.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository <Location, Long> {

    /*
* supports:
    Creating new instances
    Updating existing ones
    Deleting
    Finding (one, all, by simple or complex properties)
* */
}
