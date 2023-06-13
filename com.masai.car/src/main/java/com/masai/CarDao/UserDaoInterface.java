package com.masai.CarDao;

import com.masai.Entity.User;
import com.masai.Exception.SomethingWentwrongException;

public interface UserDaoInterface {
	public void adduser(User u) throws SomethingWentwrongException;

}
