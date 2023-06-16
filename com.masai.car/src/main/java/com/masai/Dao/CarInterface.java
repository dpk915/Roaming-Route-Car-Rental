package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Entity.Car;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public interface CarInterface {
	public void addCarDetails(Car car) throws SomethingWentwrongException;
	public Car  getCarById(long carId) throws NorecordFoundException;
	public void updateCarDetailsById(Long carId, Car updatedCar) throws NorecordFoundException;
	public void deleteCarDetails(Long carId);
	public void confirmOrRejectBooking(Booking booking, boolean isConfirmed);
	public List<Car> seAllCars() throws NorecordFoundException;
}
