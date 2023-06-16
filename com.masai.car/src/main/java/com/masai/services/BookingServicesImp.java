package com.masai.services;

import com.masai.Dao.Bookingimpl;
import com.masai.Dao.Bookinginterface;
import com.masai.Entity.Booking;

public class BookingServicesImp implements Bookingservices {
Bookinginterface booking=new Bookingimpl();
	@Override
	public void addbooking(Booking b) {
		// TODO Auto-generated method stub
		booking.bookingdone(b);
	}

	

}
