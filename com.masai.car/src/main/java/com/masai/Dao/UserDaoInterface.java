package com.masai.Dao;

import java.util.List;

import com.masai.Carbooking.com.masai.car.LoggedInId;
import com.masai.Entity.User;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public interface UserDaoInterface {
	public void adduser(User u) throws SomethingWentwrongException;
	public void login(String username, String password) throws SomethingWentwrongException;
	public void changepassword(String oldpassword,String newPassword) throws SomethingWentwrongException;
	public User findbyid(int id) throws NorecordFoundException;
	public void updateuserbooking(User b) throws SomethingWentwrongException;
    public List<Object[]> viewbookings(int id) throws SomethingWentwrongException, NorecordFoundException;
    public List<User> viewAlluser() throws SomethingWentwrongException, NorecordFoundException;
}
