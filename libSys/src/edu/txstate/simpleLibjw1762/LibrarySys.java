package edu.txstate.simpleLibjw1762;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LibrarySys implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9001L;
	private static LibrarySys instance = null;
	private libUser curUser;
	
	
	private ArrayList<libUser> users;
	private ArrayList<Book> books;
	private ArrayList<Journal> journals;
	private ArrayList<Video> videos;
	private ArrayList<Conference> conferences;
	private ArrayList<Loan> loans;
	//public menuLevel curMenu;
	
	protected LibrarySys()
	{
		users = new ArrayList<libUser>();
		books = new ArrayList<Book>();
		journals = new ArrayList<Journal>();
		videos = new ArrayList<Video>();
		conferences = new ArrayList<Conference>();
		loans = new ArrayList<Loan>();		
	}

	public static LibrarySys getInstance()
	{
		if(instance == null)
		{
			instance = new LibrarySys();
		}
		return instance;
	}	
	
	public void loadFiles()
	{
		String file = "userReg.txt";
		try
		{
			InputStream input = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			//Skip Heading
			
			while((line = buffer.readLine()) != null)
			{
				//System.out.println(line);
				
				String data[] = Arrays.copyOf(line.split("\\t"),  4);
				String name = data[0];
				String id = data[1];
				String userVer = data[2];
				String password = data[3];
				
				users.add(new libUser(name, password, userVer, id));
			}
			buffer.close();
		}
		catch (Exception err)
		{
			System.out.println(err.toString());
		}
		
		file = "bookReg.txt";
		try
		{
		InputStream in = new FileInputStream(file);
		InputStreamReader rdr = new InputStreamReader(in);
		BufferedReader bf = new BufferedReader(rdr);
		
		String line = bf.readLine();
		//StringTokenizer st = new StringTokenizer(line, "\t");
		
		//Skip Heading
		while ((line = bf.readLine()) != null)
		{
			//System.out.println(line);	
			
			String data[] = Arrays.copyOf(line.split("\\t"), 6);
			String title = data[0];
			String publisher = data[1];
			String date = data[2];
			String isbn = data[3];
			String copies = data[4];
			String author = data[5];
			books.add(new Book(title, publisher, date, isbn, copies, author));
		}
		//System.out.println(books);
		bf.close();
		}catch(Exception err)
		{
			System.out.println(err.toString());
		}
			
		
		file = "magReg.txt";
		try
		{
			InputStream input = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(reader);
			
			String line = buffer.readLine();
			//Skip heading
			
			while((line = buffer.readLine()) != null)
			{
				//System.out.println(line);
				String data[] = Arrays.copyOf(line.split("\\t"),  6);
				String title = data[0];
				String pubDate = data[1];
				String vol = data[2];
				String iss = data[3];
				String publisher = data[4];
				String articles = data[5];
				conferences.add(new Conference(title, pubDate, vol, iss, publisher, articles));
			}
			
			buffer.close();
		}catch(IOException err){
			System.out.println(err.toString());
		}
		//System.out.println(conferences);
	}
	
	//NOT COMPLETE?
	public void loanItem(libUser curUser, Document doc)
	{
		loans.add(new Loan(curUser, doc));
		System.out.println(String.format("% has been checked out by %", doc, curUser));
	}
	
	public void returnItem(libUser curUser, Document curDoc)
	{
		for(Loan target : loans)
		{
			if(target.user == curUser && target.document == curDoc)
			{
				loans.remove(target);
				System.out.println(String.format("% returned by %", curDoc, curUser));
			}
		}
	}
	
	public ArrayList<Loan> getLoanedItems()
	{
		return loans;
	}
		
	//Done! -- Adds a user to arrayList of users (For Staff only).
	public void addUser() throws IOException
	{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		//New buffer for reading input.
		System.out.println("Please enter desired username: ");
		String userName = buffer.readLine();
		
		System.out.println("Please enter desired password: ");	
		String password = buffer.readLine();
		
		System.out.println("Please enter an ID number for user: ");
		String id = buffer.readLine();
		
		System.out.println("Please enter user type (Case matters): ");
		System.out.println("Student");
		System.out.println("Faculty");
		System.out.println("Staff");
		String userVer = buffer.readLine();
		
		libUser newUser = new libUser(userName, password, userVer, id);
		users.add(newUser);
		System.out.println(newUser + " added!");
		buffer.close();
	}
	
	public void delUser(libUser user)
	{
		users.remove(user);
		System.out.println(user + " deleted!");
	}
	
	public libUser login(String userName, String password)
	{
		for (libUser target : users) 
		{
			System.out.println("In for loop");
			if(target.userName.equalsIgnoreCase(userName) && target.password.equals(password))
			{
				curUser = target;
				System.out.println("Login success!");
			}
			else{
				System.out.println("Login failure!");
				}
		}
		return curUser;
	}
	
	public void logout()
	{
		libUser user = getCurUser();
		setCurUser(null);
		System.out.println(user + " logged out.");
	}
			
	public ArrayList<Journal> getJournals()
	{
		return journals;
	}
	
	public ArrayList<Book> getBooks()
	{		
		return books;
	}
	
	public ArrayList<Video> getVideos()
	{
		return videos;
	}
	
	public ArrayList<Conference> getConference()
	{
		return conferences;
	}

	public void addBook(Book b) 
	{
		books.add(b);
	}
	
	//PARTIAL IMPLEMENTATION
	public Object doSearch(String search)
	{
		for(Book target : books)
		{
			if(target.title.equalsIgnoreCase(search) || target.author.equalsIgnoreCase(search))
			{
				return target;
			}
		}
		for(Journal target : journals)
		{
			if(target.title.equalsIgnoreCase(search) || target.author.equalsIgnoreCase(search))
			{
				return target;
			}
		}
		for(Conference target : conferences)
		{
			if(target.title.equalsIgnoreCase(search) || target.publisher.equalsIgnoreCase(search))
			{
				return target;
			}
		}
		return null;
	}

	public void addJournal(Journal j)
	{
		journals.add(j);
	}

	public void addVideo(Video v) 
	{
		videos.add(v);	
	}

	public void addConference(Conference c)
	{
		conferences.add(c);			
	}

	public ArrayList<libUser> getUsers() 
	{
		return users;
	}

	public ArrayList<Loan> getLoans() 
	{
		return loans;
	}

	public libUser getCurUser() {
		return curUser;
	}

	public void setCurUser(libUser curUser) {
		this.curUser = curUser;
	}
	/*
	public void setMenu(){
		
	}
	*/
	public Console getMenu(){
		Console current = null;
		if(currentMenu){
			
		}
	}
}