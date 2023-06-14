package com.masai.UI;

import java.util.Scanner;

import com.masai.Exception.SomethingWentwrongException;
import com.masai.services.UserServicesImpl;
import com.masai.services.UserServicesinterface;

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

}
