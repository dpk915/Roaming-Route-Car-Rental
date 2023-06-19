package com.masai.services;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public interface Bookingservices {
public void addbooking(Booking b) throws SomethingWentwrongException ;
public  List<Booking> viewbookings();
public void confirmorrejectser(int id,String str);
public void Cancelbookingser(int id) throws NorecordFoundException;
public List<Booking> pendingbooking();
public List<Booking> confirmedbooking();

}
