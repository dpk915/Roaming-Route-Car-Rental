package com.masai.Utilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBUtilities {
	
	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("car_connection");
	}
	
	public static EntityManager createconnection() {
		return emf.createEntityManager();
	}

}
