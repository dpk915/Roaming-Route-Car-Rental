package com.masai.Entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

   
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")

    private User user;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "status" )
    private String status;

    // Constructors, getters, and setters

    public Booking() {
    }

    public Booking(User userId, Long carId, Date bookingDate, String status) {
        this.user = userId;
        this.carId = carId;
        this.bookingDate = bookingDate;
        this.status = "Pending";
    }

    public Long getBookingId() {
        return bookingId;
    }

   

    public User getUserId() {
        return user;
    }

    public void setUserId(User userId) {
        this.user = userId;
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

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", carId=" + carId + ", bookingDate="
				+ bookingDate + ", status=" + status + "]";
	}
    
}
