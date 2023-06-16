package com.masai.Dao;

import com.masai.Entity.Booking;
import com.masai.Utilities.DBUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Bookingimpl implements Bookinginterface {

	@Override
	public void bookingdone(Booking b) {
		
		 EntityManager em = null;
		    EntityTransaction et = null;

		    try {
		    	em=DBUtilities.createconnection();
		        et = em.getTransaction();
		        et.begin();
		        em.persist(b);
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

}
