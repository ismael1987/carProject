package com.sunny.model;

/**
 * Created by Sunny on 8/2/2019.
 */

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data//a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
@Entity
@Table(name = "CUSTOMER")
public class Customer {//has a many to many relationship to cars via booking
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Long customer_id;
    private Integer role;
    private String driver_license;
    private Integer age;
    private String first_name;
    private String last_name;
    private String username;
    private String pwd;
   // private List<Booking> bookings_list;
    //private Set<Booking> bookings = new HashSet<Booking>();


    @OneToMany(targetEntity=Booking.class, mappedBy="customer")
    @JsonBackReference
    private List<Booking> bookings_list;

    public List<Booking> getBookings_list() {
        return bookings_list;
    }

    public void setBookings_list(List<Booking> bookings_list) {
        this.bookings_list = bookings_list;
    }

    public void addBooking (Booking booking){
        this.bookings_list.add(booking);
    }

    /*
    private ArrayList<Booking> bookings;

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking (Booking booking){
        this.bookings.add(booking);
    }
    */
    /*
    public Set<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    public void addBooking (Booking booking){
        this.bookings.add(booking);
    }
*/
    //getters and setters


    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!customer_id.equals(customer.customer_id)) return false;
        if (role != null ? !role.equals(customer.role) : customer.role != null) return false;
        if (driver_license != null ? !driver_license.equals(customer.driver_license) : customer.driver_license != null)
            return false;
        if (age != null ? !age.equals(customer.age) : customer.age != null) return false;
        if (first_name != null ? !first_name.equals(customer.first_name) : customer.first_name != null) return false;
        if (last_name != null ? !last_name.equals(customer.last_name) : customer.last_name != null) return false;
        if (username != null ? !username.equals(customer.username) : customer.username != null) return false;
        if (pwd != null ? !pwd.equals(customer.pwd) : customer.pwd != null) return false;
        return bookings_list != null ? bookings_list.equals(customer.bookings_list) : customer.bookings_list == null;
    }

    @Override
    public int hashCode() {
        int result = customer_id.hashCode();
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (driver_license != null ? driver_license.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (bookings_list != null ? bookings_list.hashCode() : 0);
        return result;
    }
}
