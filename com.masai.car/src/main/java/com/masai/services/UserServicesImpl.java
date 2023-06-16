package com.masai.services;

import java.util.List;

import com.masai.Carbooking.com.masai.car.LoggedInId;
import com.masai.Dao.UserDaoInterface;
import com.masai.Dao.UserImplDao;
import com.masai.Entity.User;
import com.masai.Exception.NorecordFoundException;
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

	@Override
	public User findbyidser(int id) throws SomethingWentwrongException, NorecordFoundException {
		
		UserDaoInterface user=new UserImplDao();
		return user.findbyid(id);
	}

	@Override
	public void updateuserbooking(User u) throws SomethingWentwrongException {
		// TODO Auto-generated method stub
		UserDaoInterface user=new UserImplDao();
		user.updateuserbooking(u);
	}

	@Override
	public List<Object[]> viewbookingser(int id) throws SomethingWentwrongException, NorecordFoundException {
		UserDaoInterface user=new UserImplDao();
		return user.viewbookings(id);
	}

	
}
