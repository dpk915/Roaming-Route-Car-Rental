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
import com.masai.services.UserServicesImpl;
import com.masai.services.UserServicesinterface;

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
                	confirmorreject();
                    break;
                case 5:
                    // Generate reports
                   // generateReports();
                	generateReports();
                    break;
                case 6:
                	viewallCars();
                	break;
                case 7:
                	viewallbookings();
                	break;
                case 8:
                	viewalluser();
                case 0:
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
        System.out.println("7. View All Bookings");
        System.out.println("0. Logout");
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
    	   System.out.println("Booking Id "+in.getBookingId()+" Status :-"+in.getStatus()+"  Date :"+in.getBookingDate()+" User id "+in.getUser().getUserId());
       }
    }
    
    public static void confirmorreject() throws NorecordFoundException {
    	
    	System.out.println("Enter Booking Id to perform operations");
    	int id=scanner.nextInt();
    	System.out.println("Please type confirmed or rejeced");
    	String status=scanner.next();
    	
    	try {
    		 Bookingservices booking = new BookingServicesImp();
    		 booking.confirmorrejectser(id, status.toLowerCase());
    	}catch(PersistenceException e) {}
    }

    	
    public static  void generateReports() {
        // Display menu options to the admin
        System.out.println("=== Generate Reports ===");
        System.out.println("1. Number of Bookings");
        
        System.out.println("2. Revenue Generated");
        
        System.out.println("3. Back to Admin Menu");

        // Read user input
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
               generateBookingReport();
                break;
            case 2:
              //  generateRevenueReport();
                break;
            case 3:
                // Go back to the admin menu
                AdminUi adminUI = new AdminUi();
                adminUI.showAdminMenu();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    public static  void generateBookingReport() {
        // Display menu options to the admin
        System.out.println("=== Generate Reports ===");
        System.out.println("1. Number of Bookings Pending");
        
        System.out.println("2. Number of confirmed Booking ");
        
        System.out.println("3. Back to Reports");

        // Read user input
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	genratepending();
            	
                break;
            case 2:
            	genrateconfirmed();
                break;
            case 3:
                // Go back to the admin menu
               generateReports();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    static void genratepending() {
    	Bookingservices b=new BookingServicesImp();
        List<Booking> list = b.pendingbooking();
        System.out.println(" Total Pending Bookings are  "+ list.size());
        list.stream().forEach(x->System.out.println(x));
    }
    static void genrateconfirmed() {
    	Bookingservices b=new BookingServicesImp();
        List<Booking> list = b.confirmedbooking();
        System.out.println(" Total confirmed Bookings are "+list.size());
        list.stream().forEach(x->System.out.println(x));
    }
    
  public static  void viewalluser() throws SomethingWentwrongException, NorecordFoundException {
	  UserServicesinterface user=new UserServicesImpl();
	  List<User> list=user.viewusersser();
	  for(User in :list) {
		  System.out.println("User Name "+in.getUsername()+" User id "+in.getUserId()+" User Mail "+in.getMailid() +" Total Bookings "+in.getBookings().size());
	  }
	  
  }
}

