package com.sunny.model;

/**
 * Created by Sunny on 7/29/2019.
 *
 */

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;//for the image

import java.util.Arrays;
import java.util.List;


//@Data//a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
@Entity
@Table(name="CAR")
public class Car {//m:1 cardinality between car and location -> the uml n side which is the car entity merges with the relationship
                    //has a many to 1 relationship to location and
                  //has a many to many relationship to customer via bookings

    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Long car_id;
    private Integer location_id;
    private String number_plate;
    private String category;
    private String color;
    private String make;
    private String model;
    private String man_year;
    private Integer rate;
    private byte[] image;
    private String image_url;
    //private List<Booking> bookings_list;

    @ManyToOne
    @JoinColumn(name="location_id", insertable = false, updatable = false)
    private Location location;//a car can only be in one location,therefore no list of location needed

    @OneToMany(targetEntity=Booking.class, mappedBy="car")
    /*@JsonManagedReference
    private List<Booking> bookings_list;

    public List<Booking> getBookings_list() {
        return bookings_list;
    }
    public void setBookings_list(List<Booking> bookings_list) {
        this.bookings_list = bookings_list;
    }
    public void addBookings(Booking booking) {
        this.bookings_list.add(booking);
    }
*/
    //getters and setters

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    //@JsonBackReference
    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getNumber_plate() {
        return number_plate;
    }

    public void setNumber_plate(String number_plate) {
        this.number_plate = number_plate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMan_year() {
        return man_year;
    }

    public void setMan_year(String man_year) {
        this.man_year = man_year;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!car_id.equals(car.car_id)) return false;
        if (!location_id.equals(car.location_id)) return false;
        if (number_plate != null ? !number_plate.equals(car.number_plate) : car.number_plate != null) return false;
        if (category != null ? !category.equals(car.category) : car.category != null) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (man_year != null ? !man_year.equals(car.man_year) : car.man_year != null) return false;
        if (rate != null ? !rate.equals(car.rate) : car.rate != null) return false;
        if (!Arrays.equals(image, car.image)) return false;
        if (image_url != null ? !image_url.equals(car.image_url) : car.image_url != null) return false;
        if (location != null ? !location.equals(car.location) : car.location != null) return false;
        return bookings_list != null ? bookings_list.equals(car.bookings_list) : car.bookings_list == null;
    }

    @Override
    public int hashCode() {
        int result = car_id.hashCode();
        result = 31 * result + location_id.hashCode();
        result = 31 * result + (number_plate != null ? number_plate.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (man_year != null ? man_year.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (image_url != null ? image_url.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (bookings_list != null ? bookings_list.hashCode() : 0);
        return result;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (car_id != null ? !car_id.equals(car.car_id) : car.car_id != null) return false;
        if (location_id != null ? !location_id.equals(car.location_id) : car.location_id != null) return false;
        if (number_plate != null ? !number_plate.equals(car.number_plate) : car.number_plate != null) return false;
        if (category != null ? !category.equals(car.category) : car.category != null) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (man_year != null ? !man_year.equals(car.man_year) : car.man_year != null) return false;
        if (rate != null ? !rate.equals(car.rate) : car.rate != null) return false;
        if (!Arrays.equals(image, car.image)) return false;
        if (image_url != null ? !image_url.equals(car.image_url) : car.image_url != null) return false;
        return location != null ? location.equals(car.location) : car.location == null;
    }

    @Override
    public int hashCode() {
        int result = car_id != null ? car_id.hashCode() : 0;
        result = 31 * result + (location_id != null ? location_id.hashCode() : 0);
        result = 31 * result + (number_plate != null ? number_plate.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (man_year != null ? man_year.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (image_url != null ? image_url.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
    /*
    @Id
    @Column(name="CarID")
    private long carID;

    @Column(name="LocationID")
    private int location_id;

    @Column(name="Color")
    private String color;

*/


}
