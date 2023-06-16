package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Entity.Car;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;
import com.masai.Utilities.DBUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CarImp implements CarInterface {

	@Override
	public void addCarDetails(Car car) throws SomethingWentwrongException {
	    EntityManager em = null;
	    EntityTransaction et = null;

	    try {
	    	em=DBUtilities.createconnection();
	        et = em.getTransaction();
	        et.begin();
	        em.persist(car);
	        et.commit();
	    } catch (Exception e) {
	        if (et != null) {
	            et.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}
    @Override
	public void updateCarDetailsById(Long carId, Car updatedCar) {
	    EntityManager em = null;
	    EntityTransaction et = null;

	    try {
	    	em=DBUtilities.createconnection();
	        et = em.getTransaction();
	        et.begin();

	        Car car = em.find(Car.class, carId);
	        if (car != null) {
	            car.setModel(updatedCar.getModel());
	            car.setBrand(updatedCar.getBrand());
	            car.setPrice(updatedCar.getPrice());
	            car.setAvailability(updatedCar.isAvailability());
	            em.merge(car);
	            et.commit();
	        } else {
	           throw new NorecordFoundException("No Cr available with this id");
	        }
	    } catch (Exception e) {
	        if (et != null) {
	            et.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}
    @Override
	public void deleteCarDetails(Long carId) {
	    EntityManager em = null;
	    EntityTransaction et = null;

	    try {
	    	em=DBUtilities.createconnection();
	        et = em.getTransaction();
	        et.begin();

	        Car car = em.find(Car.class, carId);
	        if (car != null) {
	            em.remove(car);
	            et.commit();
	        } else {
	           throw new NorecordFoundException("No car available with this id");
	        }
	    } catch (Exception e) {
	        if (et != null) {
	            et.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}
   
	public Car getCarById(long carId) throws NorecordFoundException {
	    EntityManager em = DBUtilities.createconnection();
	    try {
	        return em.find(Car.class, carId);
	    } 
	    catch(PersistenceException e){
	    	throw new NorecordFoundException("NO car available with this id");
	    }finally {
	        em.close();
	    }
	}


	


	@Override
	public void confirmOrRejectBooking(Booking booking, boolean isConfirmed) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Car> seAllCars() throws NorecordFoundException {
		EntityManager em = null;
		List<Car> list=null;
	    try {
	    	em=DBUtilities.createconnection();
	        String jpql = "SELECT c FROM Car c";
	        Query query = em.createQuery(jpql);
	         list =query.getResultList();
	         return list;
	    }catch(PersistenceException p) {
	    	throw new NorecordFoundException("No Car available");
	    } 
	    finally {
	    	
	        em.close();
	    }
		
	}


}
