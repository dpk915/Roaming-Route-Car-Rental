package com.masai.services;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Entity.Car;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public interface CarServiceInterface {
	public void addCarDetailsSer(Car car) throws SomethingWentwrongException;
	public Car getCarByIdSer(long carId) throws NorecordFoundException;
	public void updateCarDetailsByIdSer(Long carId, Car updatedCar) throws NorecordFoundException;
	public void deleteCarDetailsSer(Long carId) throws NorecordFoundException;
	public void confirmOrRejectBookingSer(Booking booking, boolean isConfirmed);
	public List<Car> viewAllcars() throws NorecordFoundException;
}
