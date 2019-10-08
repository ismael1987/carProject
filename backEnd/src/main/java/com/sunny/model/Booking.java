package com.sunny.model;

/**
 * Created by Sunny on 8/2/2019.
 */

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Data//a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
@Entity
@Table(name = "BOOKING")
public class Booking {//the relationship table => no merging because the cardinality is m:n
    //specifies how the manyToMany association is formed between the two entities
    //has a many to one to each entitty
    //and the entities have a one to many to the relation

    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private Long booking_id;//using a separate key instead of composite key (embeddable composite key class)
    //private Integer customer_id;//via object see below @manyToOne
    //private Integer car_id;//via object see below @manyToOne
    private Date start_date;
    private Date end_date;
    private Date return_date;
    private Integer total_price;

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="car_id")
    private Car car;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Booking booking = (Booking) o;

        if (!booking_id.equals(booking.booking_id)) return false;
        if (start_date != null ? !start_date.equals(booking.start_date) : booking.start_date != null) return false;
        if (end_date != null ? !end_date.equals(booking.end_date) : booking.end_date != null) return false;
        if (return_date != null ? !return_date.equals(booking.return_date) : booking.return_date != null) return false;
        if (total_price != null ? !total_price.equals(booking.total_price) : booking.total_price != null) return false;
        if (customer != null ? !customer.equals(booking.customer) : booking.customer != null) return false;
        return car != null ? car.equals(booking.car) : booking.car == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + booking_id.hashCode();
        result = 31 * result + (start_date != null ? start_date.hashCode() : 0);
        result = 31 * result + (end_date != null ? end_date.hashCode() : 0);
        result = 31 * result + (return_date != null ? return_date.hashCode() : 0);
        result = 31 * result + (total_price != null ? total_price.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }

//getters and setters via Lombok


}
