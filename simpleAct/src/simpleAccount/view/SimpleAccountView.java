package simpleAccount.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import simpleAccount.controller.SimpleAccountController;
import simpleAccount.model.SimpleAccountModel;
import simpleAccount.model.User;
import simpleAccount.model.ModelEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleAccountView.
 */
public class SimpleAccountView extends JFrameView {
	
	/** The Constant USD. */
	public static final String USD = "Edit in USD";
	
	/** The Constant EURO. */
	public static final String EURO = "Edit in Euros";
	
	/** The Constant YUAN. */
	public static final String YUAN = "Edit in Yuan";
	
	/** The Constant SAVE. */
	public static final String SAVE = "Save";
	
	/** The Constant EXIT. */
	public static final String EXIT = "Exit";
	
	/** The file name. */
	public static String fileName;
	
	/** The jcb. */
	public JComboBox<String> jcb;
	
	/** The index. */
	public int index = 0;
	
	/** The users. */
	public static ArrayList<User> users = new ArrayList<User>(); 
	
	/**
	 * Instantiates a new simple account view.
	 *
	 * @param model the model
	 * @param controller the controller
	 */
	public SimpleAccountView(SimpleAccountModel model, SimpleAccountController controller) {
		super(model, controller);
		jcb = new JComboBox<>();
		for(User user : users)
			jcb.addItem("ID: " + user.getID() + " Name: " + user.getName());
		jcb.setSize(100,300);
		this.getContentPane().add(jcb, BorderLayout.NORTH);
		this.setTitle("Main Menu");
		this.setPreferredSize(new Dimension(500, 300));
		this.setVisible(true);
		this.setAlwaysOnTop( true );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttonPanel = new JPanel();
		Handler handler = new Handler();
		jcb.addActionListener(handler);
		JButton editUSD = new JButton(USD);
		editUSD.addActionListener(handler);
		JButton editEuro = new JButton(EURO);
		editEuro.addActionListener(handler);
		JButton editYuan = new JButton(YUAN);
		editYuan.addActionListener(handler);
		buttonPanel.setLayout(new GridLayout(3, 1, 20, 5));
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.add(editUSD, null);
		buttonPanel.add(editEuro, null);
		buttonPanel.add(editYuan, null);
		JPanel savePanel = new JPanel();
		JButton exit = new JButton(EXIT);
		exit.addActionListener(handler);
		JButton save = new JButton(SAVE);
		save.addActionListener(handler);
		savePanel.setLayout(new GridLayout(1, 2, 20, 5));
		this.getContentPane().add(savePanel, BorderLayout.SOUTH);
		savePanel.add(save,  null);
		savePanel.add(exit, null);
		pack();
	}

	/* (non-Javadoc)
	 * @see simpleAccount.model.ModelListener#modelChanged(simpleAccount.model.ModelEvent)
	 */
	public void modelChanged(ModelEvent event) {
		users.get(index).setBalance(event.getAmount());
	}

	/**
	 * The Class Handler.
	 */
	public class Handler implements ActionListener {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jcb)
			{
				index = jcb.getSelectedIndex();
			}
			else
				((SimpleAccountController) getController()).operation(e.getActionCommand(),
						users.get(index), 0);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		fileName = "input.txt";
		try
		{
			InputStream ips = new FileInputStream(fileName);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String name;
			String line;
			String accountNumber;
			String balance;
			int accountNumber2;
			double balance2;
		    br.readLine();//Ignore headers.
		    br.readLine();
			try
			{
				while((line = br.readLine()) != null)
				{
					String dataValue[] = Arrays.copyOf(line.split("\t"), 3);
					name = dataValue[0];
					accountNumber = dataValue[1];
					balance = dataValue[2];
					balance2 = Double.parseDouble(balance.substring(1));
					accountNumber2 = Integer.parseInt(accountNumber);
					users.add(new User(name, accountNumber2, balance2));
				}
				new SimpleAccountController();
			}
			catch(NumberFormatException e)
			{
				System.err.println("Unable to import users " + e);
			}
			finally
			{
				br.close();
			}
		}
		catch(IOException e)
		{
			System.err.println("Cannot open given file: " + e);
		}
	}
}