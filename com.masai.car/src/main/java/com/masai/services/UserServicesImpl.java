package com.masai.services;

import com.masai.CarDao.UserDaoInterface;
import com.masai.CarDao.UserImplDao;
import com.masai.Entity.User;
import com.masai.Exception.SomethingWentwrongException;

public class UserServicesImpl implements UserServicesinterface {

	@Override
	public void adduserservices(User u) throws SomethingWentwrongException {
		UserDaoInterface user=new UserImplDao();
		user.adduser(u);
		
		
	}

	@Override
	public void loginuser(String username, String Password) throws SomethingWentwrongException {
		UserDaoInterface user=new UserImplDao();
		user.login(username, Password);
		
	}

	@Override
	public void changeoldpassword(String oldpassword, String newpassword) throws SomethingWentwrongException {
		UserDaoInterface user=new UserImplDao();
		user.changepassword(oldpassword, newpassword);
		
	}

	
}
