package com.masai.CarDao;

import com.masai.Carbooking.com.masai.car.LoggedInId;
import com.masai.Entity.User;
import com.masai.Exception.SomethingWentwrongException;

public interface UserDaoInterface {
	public void adduser(User u) throws SomethingWentwrongException;
	public void login(String username, String password) throws SomethingWentwrongException;
	public void changepassword(String oldpassword,String newPassword) throws SomethingWentwrongException;

}
