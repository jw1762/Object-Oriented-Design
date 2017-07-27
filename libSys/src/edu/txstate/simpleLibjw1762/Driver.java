package edu.txstate.simpleLibjw1762;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Driver {
	
	protected static Scanner scan = new Scanner(System.in);
	static LibrarySys libSys;
	static Console console;
	public static void main(String[] args)
	{
			libSys = loadSaved();
			if (libSys == null)
			{
				libSys = LibrarySys.getInstance();	
				libSys.loadFiles();
			}
			
			//Get single console instance;
		/*	if (console == null)
			{
				console = Console.getConsole();
			}*/
			libSys.getMenu();
			
		//libSys.login("Jordan Williamson", "user"); //LOGIN WORKS HERE, BUT NOT IN CONSOLE.
		//System.out.println(libSys.getUsers());	
		//Console.mainMenu();
		//System.out.println(libSys.doSearch("Common Framework")); //WORKS HERE, NOT IN CONSOLE.
		//System.out.println(libSys.getBooks());
	//	Console.studentMenu();
		
		//System.out.println(libSys.getLoans());
		//System.out.println(libSys.getLoanedItems());
		
		storeData();
	}

	private static LibrarySys loadSaved() 
	{
		LibrarySys loadData = null;
		try
		{
		FileInputStream fis = new FileInputStream("savedData.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		loadData = (LibrarySys)ois.readObject();
		ois.close();
		fis.close();
		}
		catch(Exception err)
		{
			System.out.println(err);
		}
		return loadData;
	}
	
	private static void storeData()
	{
		try
		{
		FileOutputStream fos = new FileOutputStream("savedData.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(libSys);
		oos.close();
		fos.close();
		System.out.println("savedData.ser written to disk.");
		}
		catch(Exception err)
		{
			System.out.println(err);
		}
	}
	
}
