package com.masai.CarDao;

import com.masai.Entity.User;
import com.masai.Exception.SomethingWentwrongException;
import com.masai.Utilities.DBUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class UserImplDao implements UserDaoInterface {

	@Override
	public void adduser(User u) throws SomethingWentwrongException {
		EntityManager em=null;
		EntityTransaction et=null;
		try {
			em=DBUtilities.createconnection();
			et=em.getTransaction();
			et.begin();
			em.persist(u);
			et.commit();
		}catch( PersistenceException ex) {
		 throw new SomethingWentwrongException("Unable to add data");
	}finally {
		em.close();
		}
	}

}
