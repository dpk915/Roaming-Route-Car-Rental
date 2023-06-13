package com.masai.services;

import com.masai.CarDao.UserDaoInterface;
import com.masai.CarDao.UserImplDao;
import com.masai.Entity.User;
import com.masai.Exception.SomethingWentwrongException;

public class ServicesImpl implements Servicesinterface {

	@Override
	public void adduserservices(User u) throws SomethingWentwrongException {
		UserDaoInterface user=new UserImplDao();
		user.adduser(u);
		
		
	}

	
}
