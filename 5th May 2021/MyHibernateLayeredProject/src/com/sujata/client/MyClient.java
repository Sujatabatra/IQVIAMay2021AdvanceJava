package com.sujata.client;

import java.util.Scanner;

import com.sujata.presentation.EmployeePresentation;
import com.sujata.presentation.EmployeePresentationImpl;

public class MyClient {

	public static void main(String[] args) {
		EmployeePresentation presentation=new EmployeePresentationImpl();
		Scanner sc=new Scanner(System.in);
		while(true){
			presentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=sc.nextInt();
			presentation.performMenu(choice);
		}

	}

}
