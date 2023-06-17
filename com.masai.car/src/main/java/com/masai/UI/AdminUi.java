package com.masai.UI;
import java.util.List;
import java.util.Scanner;



import com.masai.Dao.Bookingimpl;
import com.masai.Dao.Bookinginterface;
import com.masai.Entity.Booking;
import com.masai.Entity.Car;
import com.masai.Entity.User;
import com.masai.Exception.NorecordFoundException;
import com.masai.Exception.SomethingWentwrongException;
import com.masai.services.BookingServicesImp;
import com.masai.services.Bookingservices;
import com.masai.services.CarServiceImpl;
import com.masai.services.CarServiceInterface;

import jakarta.persistence.PersistenceException;

public class AdminUi {






    private static final Scanner scanner = new Scanner(System.in);

    public static void performAdminOperations() throws SomethingWentwrongException, NorecordFoundException {
        while (true) {
            showAdminMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Add new car details
                    addCarDetails();
                    break;
                case 2:
                    // Update existing car details
                    updateCarDetails();
                    break;
                case 3:
                    // Delete car details
                    deleteCarDetails();
                    break;
                case 4:
                    // Confirm or reject car bookings
                    confirmOrRejectBookings();
                    break;
                case 5:
                    // Generate reports
                   // generateReports();
                	viewallbookings();
                    break;
                case 6:
                	viewallCars();
                	break;
                case 7:
                    // Logout
                    System.out.println("Logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showAdminMenu() {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Add Car Details");
        System.out.println("2. Update Car Details");
        System.out.println("3. Delete Car Details");
        System.out.println("4. Confirm or Reject Bookings");
        System.out.println("5. Generate Reports");
        System.out.println("6. View All Cars");
        System.out.println("7. Logout");
        System.out.print("Choice: ");
    }

    private static void addCarDetails() throws SomethingWentwrongException {
        
    	Scanner scanner = new Scanner(System.in);

        System.out.println("----- Add Car Details -----");
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter car price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter car availability (true/false): ");
        boolean availability = scanner.nextBoolean();

        Car car = new Car(model, brand, price, availability);
        CarServiceInterface c=new CarServiceImpl();
        try {
        	
        c.addCarDetailsSer(car);
        }catch(PersistenceException e) {
        	System.out.println(e.getMessage());
        }

        System.out.println("Car details added successfully!");
    }

    private static void updateCarDetails() throws NorecordFoundException, SomethingWentwrongException {
    	   Scanner scanner = new Scanner(System.in);

           System.out.println("----- Update Car Details -----");
           System.out.print("Enter car ID: ");
           long carId = scanner.nextLong();
           scanner.nextLine(); // Consume the newline character

           CarServiceInterface c=new CarServiceImpl() ;
           if (c.getCarByIdSer(carId) == null) {
               System.out.println("Car not found with ID: " + carId);
               return;
           }

           System.out.print("Enter new car model: ");
           String model = scanner.nextLine();
           System.out.print("Enter new car brand: ");
           String brand = scanner.nextLine();
           System.out.print("Enter new car price: ");
           double price = scanner.nextDouble();
           System.out.print("Enter new car availability (true/false): ");
           boolean availability = scanner.nextBoolean();

         Car car=c.getCarByIdSer(carId);
         car.setModel(model);
         car.setAvailability(availability);
         car.setPrice(price);
         CarServiceInterface cc=new CarServiceImpl();
		 cc.updateCarDetailsByIdSer(carId, car);

           
        		   
			
		
           System.out.println("Car details updated successfully!");
    
    }

    private static void deleteCarDetails() throws NorecordFoundException {
    	 Scanner scanner = new Scanner(System.in);

         System.out.println("----- Delete Car Details -----");
         System.out.print("Enter car ID: ");
         long carId = scanner.nextLong();
         CarServiceInterface c=new CarServiceImpl();
         Car car = c.getCarByIdSer(carId);
         if (car == null) {
             System.out.println("Car not found with ID: " + carId);
             return;
         }

         try {
        	 c.deleteCarDetailsSer(carId);
        	 
         }catch(PersistenceException e) {
        	 System.out.println(e.getMessage());
         }

         System.out.println("Car details deleted successfully!");
      
    }

    private static void confirmOrRejectBookings() {
        // Implement logic to confirm or reject car bookings here
        System.out.println("Confirm or reject bookings functionality coming soon!");
    }

    private static void generateReports() {
        // Implement logic to generate reports here
        System.out.println("Generate reports functionality coming soon!");
    }
    
    public static void viewallCars() throws NorecordFoundException {
    	CarServiceInterface c=new CarServiceImpl();
    	 c.viewAllcars();
    	for(Car in:c.viewAllcars()) {
    		System.out.println(in.toString());
    	}
    	
    }
    
    public static void viewallbookings() {
        Bookingservices booking = new BookingServicesImp();
        List<Booking> list = booking.viewbookings();
       for(Booking in :list) {
    	   System.out.println("Booking Id"+in.getBookingId()+" Status :-"+in.getStatus()+"  Date :"+in.getBookingDate()+" User id "+in.getUser().getUserId());
       }
    }

    	
    
    
   
}

