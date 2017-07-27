package simpleAccount.model;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {
	
	/** The name. */
	private String name = "";
	
	/** The id. */
	private int ID = 0;
	
	/** The balance. */
	private double balance = 0.0;
	
	/**
	 * Instantiates a new user.
	 *
	 * @param name the name
	 * @param ID the id
	 * @param balance the balance
	 */
	public User(String name, int ID, double balance)
	{
		this.name = name;
		this.ID = ID;
		this.balance = balance;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
}
