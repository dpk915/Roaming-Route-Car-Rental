package com.masai.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.masai.Dao.Bookingimpl;
import com.masai.Dao.Bookinginterface;
import com.masai.Entity.Booking;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;

public class BookingServicesImp implements Bookingservices {
static Bookinginterface booking=new Bookingimpl();
	@Override
	public void addbooking(Booking b) throws SomethingWentwrongException {
		// TODO Auto-generated method stub
		booking.bookingdone(b);
	}
	@Override
	public  List<Booking> viewbookings() {
		// TODO Auto-generated method stub
		return booking.viewallbookings();
	}
	@Override
	public void confirmorrejectser(int id, String str) {
		booking.confirmorreject(id, str);
		
	}
	@Override
	public void Cancelbookingser(int id) throws NorecordFoundException {
		booking.cancelBooking(id);
		
	}
	
	public List<Booking> pendingbooking() {
		return (List<Booking>)viewbookings().stream().filter(x->x.getStatus().equals("pending")).collect(Collectors.toList());
		
		
	}
	
	public List<Booking> confirmedbooking() {
		return (List<Booking>)viewbookings().stream().filter(x->x.getStatus().equals("confirmed")).collect(Collectors.toList());
		
		
	}

	

}
