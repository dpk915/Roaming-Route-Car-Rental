package com.masai.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private boolean availability;

    // Constructors, getters, and setters

    public Car() {
        // Default constructor
    }

    public Car(String model, String brand, double price, boolean availability) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.availability = availability;
    }

    public Long getCarId() {
        return carId;
    }

   

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", model=" + model + ", brand=" + brand + ", price=" + price + ", availability="
				+ availability + "]";
	}
    
    
}
