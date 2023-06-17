package com.masai.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "status")
    private String status;

    // Constructors, getters, and setters

    public Booking() {
    }

    public Booking(User user, Long carId, Date bookingDate, String status) {
        this.user = user;
        this.carId = carId;
        this.bookingDate = bookingDate;
        this.status = "Pending";
    }

    public Long getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
