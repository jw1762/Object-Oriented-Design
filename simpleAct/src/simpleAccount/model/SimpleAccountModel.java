package simpleAccount.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import simpleAccount.model.AbstractModel;
import simpleAccount.model.ModelEvent;
import simpleAccount.view.SimpleAccountView;
import simpleAccount.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleAccountModel.
 */
public class SimpleAccountModel extends AbstractModel {
	
	/** The df. */
	DecimalFormat df = new DecimalFormat("########.00");

	/**
	 * Withdraw USD.
	 *
	 * @param user the user
	 * @param amount the amount
	 */
	public synchronized void withdrawUSD(User user, double amount)
	{
		double balance = user.getBalance();
		balance -= amount;
		if(balance < 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Insufficient Funds", "Dialog",
			        JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			ModelEvent me = new ModelEvent(this, 1, "", balance);
			notifyChanged(me);
			notifyAll();
		}
	}
	
	/**
	 * Withdraw EURO.
	 *
	 * @param user the user
	 * @param amount the amount
	 */
	public synchronized void withdrawEURO(User user, double amount)
	{
		double balance = user.getBalance();
		balance -= (amount/.91);	
		if(balance < 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Insufficient Funds", "Dialog",
			        JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			ModelEvent me = new ModelEvent(this, 1, "", balance);
			notifyChanged(me);
			notifyAll();
		}	
	}
	
	/**
	 * Withdraw YUAN.
	 *
	 * @param user the user
	 * @param amount the amount
	 */
	public synchronized void withdrawYUAN(User user, double amount)
	{
		double balance = user.getBalance();
		balance -= (amount/6.72);
		if(balance < 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Insufficient Funds", "Dialog",
			        JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			ModelEvent me = new ModelEvent(this, 1, "", balance);
			notifyChanged(me);
			notifyAll();
		}
	}

	/**
	 * Deposit USD.
	 *
	 * @param user the user
	 * @param amount the amount
	 */
	public synchronized void depositUSD(User user, double amount)
	{
		double balance = user.getBalance();
		balance += amount;
		if(amount < 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Not a positive number", "Dialog",
			        JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			ModelEvent me = new ModelEvent(this, 1, "", balance);
			notifyChanged(me);
			notifyAll();
		}
	}
	
	/**
	 * Deposit EURO.
	 *
	 * @param user the user
	 * @param amount the amount
	 */
	public synchronized void depositEURO(User user, double amount)
	{
		double balance = user.getBalance();
		balance += (amount/.91);
		if(amount < 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Not a positive number", "Dialog",
			        JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			ModelEvent me = new ModelEvent(this, 1, "", balance);
			notifyChanged(me);
			notifyAll();
		}
	}
	
	/**
	 * Deposit YUAN.
	 *
	 * @param user the user
	 * @param amount the amount
	 */
	public synchronized void depositYUAN(User user, double amount)
	{
		double balance = user.getBalance();
		balance += (amount/6.72);
		if(amount < 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Not a positive number", "Dialog",
			        JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			ModelEvent me = new ModelEvent(this, 1, "", balance);
			notifyChanged(me);
			notifyAll();
		}
	}
	
	/**
	 * Save.
	 */
	public void save()
	{
		try
		{	
			PrintWriter pw = new PrintWriter(SimpleAccountView.fileName);
			pw.write("name	id	amount");
			pw.write("\n");
			pw.write("--------------------------------");
			pw.write("\n");
			for(User user : SimpleAccountView.users)
			{
				
				pw.write(user.getName() + "\t");
				pw.write(user.getID() + "\t");
				pw.write("$");
				pw.write(df.format((user.getBalance())));
				pw.write("\n");
			}
			pw.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Unable to open file: " + e);
		}
		finally
		{
			System.out.println("File saved.");
		}
	}
	
	/**
	 * Exit.
	 */
	public void exit()
	{
		save();
		System.exit(0);
	}
}