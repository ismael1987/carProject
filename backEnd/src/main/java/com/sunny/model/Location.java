package com.sunny.model;

/**
 * Created by Sunny on 8/2/2019.
 */

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;//that was for the image type of the car/didn't work for list gernerics
import java.util.List;

@Data//a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
@Entity
@Table(name = "LOCATION")
public class Location {//not using implements Serializable since we are using JSON
                       //has a 1 to many relationship to car

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private Long location_id;//primary key
    private String location_name;
    private String street;
    private String city;
    private String zip_code;
    private Double latitude;
    private Double longitude;


    @OneToMany(targetEntity=Car.class, mappedBy="location")
    @JsonBackReference
    //private Set<UserGroup> userGroups = new HashSet<UserGroup>();//that's the relationship table
    //but here we don't have a relationship table anymore since the relationship is merged with the car entity
    //private List<Car> cars_list;//one location can have many cars
    private List<Car> cars_list;

    //@JsonManagedReference
    public List<Car> getCars_list() {
        return cars_list;
    }
    public void setCars_list(List<Car> cars_list) {
        this.cars_list = cars_list;
    }
    public void addCars(Car car) {
        this.cars_list.add(car);
    }

//getters and setters

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Location location = (Location) o;

        if (!location_id.equals(location.location_id)) return false;
        if (location_name != null ? !location_name.equals(location.location_name) : location.location_name != null)
            return false;
        if (street != null ? !street.equals(location.street) : location.street != null) return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (zip_code != null ? !zip_code.equals(location.zip_code) : location.zip_code != null) return false;
        if (latitude != null ? !latitude.equals(location.latitude) : location.latitude != null) return false;
        if (longitude != null ? !longitude.equals(location.longitude) : location.longitude != null) return false;
        return cars_list != null ? cars_list.equals(location.cars_list) : location.cars_list == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + location_id.hashCode();
        result = 31 * result + (location_name != null ? location_name.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zip_code != null ? zip_code.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (cars_list != null ? cars_list.hashCode() : 0);
        return result;
    }
}
