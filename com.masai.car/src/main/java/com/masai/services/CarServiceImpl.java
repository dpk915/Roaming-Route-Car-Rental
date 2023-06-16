package com.masai.services;

import java.util.List;

import com.masai.Dao.CarImp;
import com.masai.Dao.CarInterface;
import com.masai.Entity.Booking;
import com.masai.Entity.Car;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public class CarServiceImpl implements CarServiceInterface{
     CarInterface c=new CarImp();
	@Override
	public void addCarDetailsSer(Car car) throws SomethingWentwrongException {
	
		c.addCarDetails(car);
	}

	@Override
	public void  updateCarDetailsByIdSer(Long carId, Car updatedCar) throws NorecordFoundException {
		// TODO Auto-generated method stub
		c.updateCarDetailsById(carId, updatedCar);
	}

	@Override
	public void deleteCarDetailsSer(Long carId) throws NorecordFoundException {
		// TODO Auto-generated method stub
		c.deleteCarDetails(carId);
		
	}

	@Override
	public void confirmOrRejectBookingSer(Booking booking, boolean isConfirmed) {
		// TODO Auto-generated method stub
		//c.updateCarDetailsById(null, null);
		
	}
	

	@Override
	public Car getCarByIdSer(long carId) throws NorecordFoundException {
		// TODO Auto-generated method stub
		 return c.getCarById(carId);
	}

	@Override
	public List<Car> viewAllcars() throws NorecordFoundException {
		return c.seAllCars();
		}

}
