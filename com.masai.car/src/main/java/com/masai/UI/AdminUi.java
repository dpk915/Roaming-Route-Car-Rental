package com.masai.UI;
import java.util.Scanner;

public class AdminUi {






    private static final Scanner scanner = new Scanner(System.in);

    public static void performAdminOperations() {
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
                    generateReports();
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

    private static void showAdminMenu() {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Add Car Details");
        System.out.println("2. Update Car Details");
        System.out.println("3. Delete Car Details");
        System.out.println("4. Confirm or Reject Bookings");
        System.out.println("5. Generate Reports");
        System.out.println("6. Logout");
        System.out.print("Choice: ");
    }

    private static void addCarDetails() {
        // Implement logic to add car details here
        System.out.println("Add car details functionality coming soon!");
    }

    private static void updateCarDetails() {
        // Implement logic to update car details here
        System.out.println("Update car details functionality coming soon!");
    }

    private static void deleteCarDetails() {
        // Implement logic to delete car details here
        System.out.println("Delete car details functionality coming soon!");
    }

    private static void confirmOrRejectBookings() {
        // Implement logic to confirm or reject car bookings here
        System.out.println("Confirm or reject bookings functionality coming soon!");
    }

    private static void generateReports() {
        // Implement logic to generate reports here
        System.out.println("Generate reports functionality coming soon!");
    }
    
   
}

