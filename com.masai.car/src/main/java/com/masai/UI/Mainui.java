package com.masai.UI;




import java.util.Scanner;

import com.masai.Entity.User;
import com.masai.Exception.SomethingWentwrongException;
import com.masai.services.ServicesImpl;
import com.masai.services.Servicesinterface;

import jakarta.persistence.PersistenceException;


public class Mainui {
    private static final Scanner sc= new Scanner(System.in);

    public static void main(String[] args) throws SomethingWentwrongException {
        showWelcomeMessage();

        boolean isLoggedIn = false;
        boolean isAdmin = false;
        int userId = 0;

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
                    userId = loginUser();
                    isLoggedIn = (userId != 0);
                    isAdmin = false;
                    break;
                case 3:
                    // Admin login
                    userId = loginAdmin();
                    isLoggedIn = (userId != 0);
                    isAdmin = (userId != 0);
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
                    performUserOperations(userId);
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
       
    	Servicesinterface ser=new ServicesImpl();
    	try {
    		User u=new User(username,Email,password);
    		ser.adduserservices(u);
    		System.out.println("User Register Succesfully");
    		
    	}catch(PersistenceException ex) {
    		System.out.println(ex.getMessage());
    	}
    }

    private static int loginUser() {
        // Implement user login logic here
        System.out.println("User login functionality coming soon!");
        return 0; // Return the user ID upon successful login
    }

    private static int loginAdmin() {
        // Implement admin login logic here
        System.out.println("Admin login functionality coming soon!");
        return 0; // Return the admin ID upon successful login
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
        System.out.println("5. Logout");
        System.out.print("Choice: ");
    }
}
