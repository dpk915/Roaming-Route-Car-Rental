package com.masai.Dao;



import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public interface Bookinginterface {
public void bookingdone(Booking b) throws SomethingWentwrongException;
public List<Booking> viewallbookings();
public void confirmorreject(int b, String str);
public void cancelBooking(int id)throws NorecordFoundException;
}
