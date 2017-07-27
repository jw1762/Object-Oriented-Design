package simpleAccount.model;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelEvent.
 */
public class ModelEvent extends ActionEvent {
	
	/** The balance. */
	private double balance;
	
	/**
	 * Instantiates a new model event.
	 *
	 * @param obj the obj
	 * @param id the id
	 * @param message the message
	 * @param balance the balance
	 */
	public ModelEvent(Object obj, int id, String message, double balance){
		super(obj, id, message);
		this.balance = balance;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount(){return balance;}
}