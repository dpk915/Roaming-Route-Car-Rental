package com.masai.UI;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.masai.Carbooking.com.masai.car.LoggedInId;
import com.masai.Entity.Booking;
import com.masai.Entity.User;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;
import com.masai.services.BookingServicesImp;
import com.masai.services.Bookingservices;
import com.masai.services.UserServicesImpl;
import com.masai.services.UserServicesinterface;

import jakarta.persistence.PersistenceException;

public class Userui {
	
public static void	changepassword(Scanner sc) {
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
    System.out.print("Enter a date (format: dd/MM/yyyy): ");
    String dateString = sc.next();

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = dateFormat.parse(dateString);
    System.out.println("Input date: " + date);

    UserServicesinterface userService = new UserServicesImpl();
    Bookingservices bookingService = new BookingServicesImp();

    User user = userService.findbyidser(userId);

    if (user != null) {
        Booking booking = new Booking(user, carId, date, status);

        Set<Booking> bookings = user.getBookings();
        bookings.add(booking);
        bookingService.addbooking(booking);
        user.setBookings(bookings);

        userService.updateuserbooking(user);
        System.out.println("Booking added successfully.");
    } else {
        throw new NorecordFoundException("User not found.");
    }
}

}
