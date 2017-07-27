package edu.txstate.simpleLibjw1762;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public abstract interface Console{
	
	static LibrarySys libSys = LibrarySys.getInstance();
	static Console console = null;
	
	static Scanner scan = new Scanner(System.in);
	/*
	public static Console getConsole()
	{
		if (console == null)
		{
			console = new Console();
		}
		return console;
	}*/
	
	public static void mainMenu()
	{
	
	System.out.println("Welcome to the Object-Oriented Simple Library System.");
	System.out.println("=====================================================");
	System.out.println("      Please speak to Library Staff to setup account.");
	System.out.println("=====================================================");
	System.out.println("\t[1] Login");
	System.out.println("\t[2] Exit");
	
	Scanner scanner = new Scanner(System.in);
	int menuChoice = scanner.nextInt();
	boolean showMenu = true;
	
	String userName = null, password = null;
	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	do{
	switch(menuChoice)
	{
	case 1:		
		System.out.println("Please enter username: ");
		try {
			userName = buffer.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Please enter password: ");
		try {
			password = buffer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println(libSys.getCurUser());//debug
		libSys.login(userName, password);
System.out.println(libSys.getCurUser());//debug
	/*	if (current.getUserVer() == "Student"){
			studentMenu();
		}
		if (current.getUserVer() == "Faculty"){
			facultyMenu();
		}
		if (current.getUserVer() == "Staff"){
			staffMenu();
		}*/
		showMenu = false;
		break;
	case 2:
		System.out.println("Exiting program...");
		showMenu = false;
		System.exit(0);
		break;
	default:
		//showMenu = false;
		System.out.println("Invalid choice.");
		break;
	}
	}while (showMenu == true);
	
	scanner.close();
	}
	
	public static void studentMenu() 
	{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		boolean showStMenu = true;
		System.out.println("====Student Menu====");
		System.out.println("[1] Search Documents");
		System.out.println("[2] Reserve Document");
		System.out.println("[3] View Your Checked-Out Items");
		System.out.println("[4] Go Back");
		System.out.println("[5] Logout");
		try {
			buffer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(choice)
		{
		case 1:
			System.out.println(libSys.doSearch("Java Programming"));
			break;
		case 2:
			//Book b1 = new Book("No Hope in Sight", "Number", "5/21/2010", "Somehwere", "55", "Mr. Nihilist");
			//reqSearch();
			//buffer.readLine();
			//libSys.loanItem(current, b1);
			break;
		case 3:
			libSys.getLoanedItems();
			break;
		case 4:
			showStMenu = false;
			mainMenu();//Maybe loop forever?
			break;
		case 5:
			showStMenu = false;
			libSys.logout();
			break;
		}
		try {
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void staffMenu()
	{
		int choice = 0;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("=====Library Staff Menu=====");
		System.out.println("[1] Add Users");
		System.out.println("[2] Add Documents");
		System.out.println("[3] List Users");
		System.out.println("[4] List Documents");
		System.out.println("[5] List all On-Loan Documents");
		System.out.println("[6] Go Back");
		System.out.println("[7] Logout");
		switch(choice)
		{
		case 1:
			try 
			{
				libSys.addUser();
			} catch (IOException e2)
			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case 2:
			int addChoice = 0;
			String title, publisher, date, isbn, copies, author;
			
			System.out.println("Please enter title: ");
			try {
				title = buffer.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Please enter publisher: ");
			try {
				publisher = buffer.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Please enter date of publication: ");
			try {
				date = buffer.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Please enter isbn: ");
			try {
				isbn = buffer.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Please enter number of copies: ");
			try {
				copies = buffer.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Please enter author: ");
			try {
				author = buffer.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("What type of document is this?");
			System.out.println("[1] Book");
			System.out.println("[2] Journal");
			System.out.println("[3] Video");
			System.out.println("[4] Conference");
			try {
				addChoice = buffer.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch(addChoice)
			{
			case 1:				
				Book b = new Book(title, publisher, date, isbn, copies, author);
				libSys.addBook(b);
				break;
			case 2: 
				Journal j = new Journal(title, publisher, date, isbn, copies, author);
				libSys.addJournal(j);
				break;
			case 3:
				Video v = new Video(title, author, publisher, date, copies);
				libSys.addVideo(v);
				break;			
			case 4:			
				Conference c = new Conference(title, publisher, date, isbn, copies, author);
				libSys.addConference(c);
				break;
			}
		
		case 3:
			System.out.println(libSys.getUsers());
		case 4:
			System.out.println(libSys.getBooks());
			System.out.println(libSys.getVideos());
			System.out.println(libSys.getJournals());
			System.out.println(libSys.getConference());
		case 5:
			System.out.println(libSys.getLoans());
		case 6:
			//libSys.setMenu();
			break;
		case 7:
			libSys.logout();
			break;
		}
		

	}
	
	public static void facultyMenu()
	{
		
	}
	 
}