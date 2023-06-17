package com.masai.services;

import java.util.List;

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
	@Override
	public List<Booking> viewbookings() {
		// TODO Auto-generated method stub
		return booking.viewallbookings();
	}

	

}
