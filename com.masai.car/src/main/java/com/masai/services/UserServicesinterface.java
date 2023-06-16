package com.masai.services;

import java.util.List;

import com.masai.Carbooking.com.masai.car.LoggedInId;
import com.masai.Entity.User;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public interface UserServicesinterface {
	public void adduserservices(User u) throws SomethingWentwrongException;
	public void loginuser(String username,String Password) throws SomethingWentwrongException;
    public void changeoldpassword(String oldpassword,String newpassword) throws SomethingWentwrongException;
    public User findbyidser(int id) throws SomethingWentwrongException, NorecordFoundException;
    public void updateuserbooking(User u) throws SomethingWentwrongException;
    
    public List<Object[]> viewbookingser(int loginId) throws SomethingWentwrongException, NorecordFoundException;
}
