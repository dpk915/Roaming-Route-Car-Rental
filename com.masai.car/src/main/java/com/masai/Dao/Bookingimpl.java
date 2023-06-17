package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Utilities.DBUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

	@Override
	

	public List<Booking> viewallbookings() {
		EntityManager em = null;
        try {
            em = DBUtilities.createconnection();
            String queryString = "SELECT b FROM Booking b JOIN FETCH b.user";

            TypedQuery<Booking> query = em.createQuery(queryString, Booking.class);
            return query.getResultList();
        } catch (Exception e) {
            // Handle any exceptions here
            e.printStackTrace();
        } finally {
            if (em != null) {
                try {
                    em.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
	}




}
