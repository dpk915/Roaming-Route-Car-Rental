package com.masai.UI;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.mapping.List;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.masai.Carbooking.com.masai.car.LoggedInId;
import com.masai.Entity.Booking;
import com.masai.Entity.Car;
import com.masai.Entity.User;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;
import com.masai.services.BookingServicesImp;
import com.masai.services.Bookingservices;
import com.masai.services.CarServiceImpl;
import com.masai.services.CarServiceInterface;
import com.masai.services.UserServicesImpl;
import com.masai.services.UserServicesinterface;

import jakarta.persistence.PersistenceException;

public class Userui {
	
public static void changepassword(Scanner sc) {
	System.out.print("Enter old password ");
	String oldPassword = sc.next();
	System.out.print("Enter new password ");
	String newPassword = sc.next();
	System.out.print("Re-Enter new password ");
	String reEnterNewPassword = sc.next();
	
	//Check if new password is correct
	if(!newPassword.equals(reEnterNewPassword)) {
		System.out.println("New password and Re-Entered password mismtached");
		return;
	}else if(newPassword.equals(oldPassword)) {
		System.out.println("New password and old password must be different");
		return;
	}
	
	try {
		UserServicesinterface userService = new UserServicesImpl();
		userService.changeoldpassword(oldPassword, reEnterNewPassword);
		System.out.println("Password updated");
	}catch(SomethingWentwrongException ex) {
		System.out.println(ex.getMessage());
	}
}
public static void bookCar(LoggedInId id, Scanner sc) throws ParseException, SomethingWentwrongException, NorecordFoundException {
    System.out.println("Please enter Car id to book");
    Long carId = sc.nextLong();
    int userId = LoggedInId.loginId;

    String status = "pending";

   

  
        
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           

            System.out.print("Enter booking date (yyyy-MM-dd): ");
            String inputDate = sc.next();

            if (inputDate.isEmpty()) {
                System.out.println("Invalid input. Booking date cannot be empty.");
                return; // Exit the method or handle the error accordingly
            }

            LocalDate manualDate = LocalDate.parse(inputDate, formatter);
            LocalDate currentDate = LocalDate.now();

            System.out.println("Input date: " + Date.valueOf(currentDate));
            System.out.println("Current date: " +Date.valueOf(currentDate));
        
   

    CarServiceInterface carservice= new  CarServiceImpl();
    UserServicesinterface userService = new UserServicesImpl();
    Bookingservices bookingService = new BookingServicesImp();

   User user = userService.findbyidser(userId);
   Car car= carservice.getCarByIdSer(carId);
   if(car==null) {
	   System.out.println("No car with this id");
   }else {
	  
   
    if(user != null && car !=null ) {
        Booking booking = new Booking(user, carId, Date.valueOf(manualDate), status,Date.valueOf(currentDate));

        Set<Booking> bookings = user.getBookings();
        bookings.add(booking);
        user.setBookings(bookings);
        userService.updateuserbooking(user);
        System.out.println("Booking added successfully.");
    } else {
        System.out.println("Something went wrong not able to book car");;
    }
   }
}
public static void viewbookings(int loginId) throws SomethingWentwrongException, NorecordFoundException {
	UserServicesinterface ser=new UserServicesImpl();

	
	try {
		
		// List<Object[]> list=ser.viewbookingser(loginId);
		
		for (Object[] bookingData : ser.viewbookingser(loginId)) {
			
		    User user = (User) bookingData[0]; // Extract the User object from the array
		    Booking booking = (Booking) bookingData[1]; // Extract the Booking object from the array
		    
		    // Print user details
		    System.out.println("User ID: " + user.getUserId()+"   Username: " + user.getUsername());
		  
		    // Print other user details as needed
		    
		   for(Booking in:user.getBookings()) {
		    System.out.println("Booking ID: " + in.getBookingId() +"  Booked_on "+ in.getBooked_on()+"Car ID: "+ in.getCarId()+" Booking Date: " + in.getBookingDate()+" Status: " + in.getStatus());
		  
		    // Print other booking details as needed
		   }
		   return;
		   // System.out.println("------------------------------------");
		}
	//	System.out.println("Total Number of Bokking for Mr. "+u.get(0).getUsername()+" is"+u.get(0).getBookings().size());
		
		
		
		
	}catch(PersistenceException e) {
		System.out.println(e.getMessage());
	}finally {
		
	}
}
public static void cancelbooking(Scanner sc) throws NorecordFoundException {
	System.out.println("Please Enter your Booking Id to cancelBooking");
	int id=sc.nextInt();
	try {
		Bookingservices b=new BookingServicesImp();
		b.Cancelbookingser(id);
		System.out.println("Booking Cancelled For Booking Id "+id);
	}catch(PersistenceException e) {
		System.out.println(e.getMessage());
	}
}
}
