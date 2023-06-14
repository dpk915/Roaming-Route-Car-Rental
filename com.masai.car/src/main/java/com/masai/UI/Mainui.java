package com.masai.UI;




import java.util.Scanner;

import com.masai.Carbooking.com.masai.car.LoggedInId;
import com.masai.Entity.User;
import com.masai.Exception.SomethingWentwrongException;
import com.masai.services.UserServicesImpl;
import com.masai.services.UserServicesinterface;

import jakarta.persistence.PersistenceException;


public class Mainui {
    private static final Scanner sc= new Scanner(System.in);

    public static void main(String[] args) throws SomethingWentwrongException {
        showWelcomeMessage();

        boolean isLoggedIn = false;
        boolean isAdmin = false;
        LoggedInId.loginId = 0;

        while (true) {
            showMainMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // User registration
                    registerUser();
                    break;
                case 2:
                    // User login
                	LoggedInId.loginId= loginUser();
                    isLoggedIn = (LoggedInId.loginId != 0);
                    isAdmin = false;
                    break;
                case 3:
                    // Admin login
                	LoggedInId.loginId = loginAdmin();
                    isLoggedIn = (LoggedInId.loginId != 0);
                    isAdmin = (LoggedInId.loginId != 0);
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Thank you for using the Car Booking Portal. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (isLoggedIn) {
                if (isAdmin) {
                    // Perform admin operations
                   // performAdminOperations();
                } else {
                    // Perform user operations
                    performUserOperations(LoggedInId.loginId);
                }
            }
        }
    }

    private static void showWelcomeMessage() {
        System.out.println("Welcome to the Car Booking Portal!");
        System.out.println("==================================");
    }

    private static void showMainMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Register as a User");
        System.out.println("2. Login as a User");
        System.out.println("3. Login as an Admin");
        System.out.println("4. Exit");
        System.out.print("Choice: ");
    }

    private static void registerUser() throws SomethingWentwrongException {
        // Implement user registration logic here
    	System.out.println("Please Enter your Email id to register");
    	String Email=sc.next();
    	System.out.println("Please Enter your user name to register");
    	String username=sc.next();
    	System.out.println("Please Enter create your password");
    	String password=sc.next();
       
    	UserServicesinterface ser=new UserServicesImpl();
    	try {
    		User u=new User(username,Email,password);
    		ser.adduserservices(u);
    		System.out.println("User Register Succesfully");
    		
    	}catch(PersistenceException ex) {
    		System.out.println(ex.getMessage());
    	}
    }

    private static int loginUser() throws SomethingWentwrongException {
    	
    	System.out.println("Please Enter your user name to login");
    	String username=sc.next();
    	System.out.println("Please Enter your password");
    	String password=sc.next();
       
    	UserServicesinterface ser=new UserServicesImpl();
    	try {
    	
    		ser.loginuser(username, password);
    		System.out.println("User login Succesfully with id  "+LoggedInId.loginId);
    		
    	}catch(PersistenceException ex) {
    		System.out.println(ex.getMessage());
    	}
       
        return LoggedInId.loginId; // Return the user ID upon successful login
    }

    private static int loginAdmin() {
    	System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			AdminUi.performAdminOperations();
		}else {
			System.out.println("Invalid Username of Password");
		}
      
        return 0; 
    }

    private static void performUserOperations(int userId) {
        while (true) {
            showUserMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // View available cars
                  //  viewAvailableCars();
                    break;
                case 2:
                    // Apply filters and sorting options
                  //  applyFiltersAndSortingOptions();
                    break;
                case 3:
                    // Book a car
                  //  bookCar(userId);
                    break;
                case 4:
                    // View booking status
                  //  viewBookingStatus(userId);
                    break;
                case 5:
                	Userui.changepassword(sc);
                	break;
                case 6:
                    // Logout
                    System.out.println("Logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showUserMenu() {
        System.out.println("\nUser Menu:");
        System.out.println("1. View Available Cars");
        System.out.println("2. Apply Filters and Sorting Options");
        System.out.println("3. Book a Car");
        System.out.println("4. View Booking Status");
        System.out.println("5. ChangePassword");
        System.out.println("6. Logout");
        System.out.print("Choice: ");
    }
}
