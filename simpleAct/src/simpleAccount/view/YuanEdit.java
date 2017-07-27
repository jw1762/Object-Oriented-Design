package simpleAccount.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

import simpleAccount.controller.SimpleAccountController;
import simpleAccount.model.ModelEvent;
import simpleAccount.model.SimpleAccountModel;
import simpleAccount.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class YuanEdit.
 */
public class YuanEdit extends JFrameView {
	
	/** The df. */
	DecimalFormat df = new DecimalFormat("########.00");
	
	/** The Constant DISMISS. */
	public static final String DISMISS = "Dismiss";
	
	/** The Constant WITHDRAW_YUAN. */
	public static final String  WITHDRAW_YUAN = "Withdraw YUAN";
	
	/** The Constant DEPOSIT_YUAN. */
	public static final String DEPOSIT_YUAN = "Deposit YUAN";
	
	/** The amount field. */
	JFormattedTextField amountField;
	
	/** The user. */
	User user;
	
	/** The jl. */
	JLabel jl;
	
	/** The amount. */
	public double amount;

	/**
	 * Instantiates a new yuan edit.
	 *
	 * @param model the model
	 * @param controller the controller
	 * @param user the user
	 */
	public YuanEdit(SimpleAccountModel model, SimpleAccountController controller, User user) {
		super(model, controller);
		this.user = user;
		this.setTitle(user.getID() + " " + user.getName() + " {YUAN}");
		this.setPreferredSize(new Dimension(500,150));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Handler handler = new Handler();
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		format.setRoundingMode(RoundingMode.DOWN); 
		amountField = new JFormattedTextField(format);
		amountField.setValue(0.00);
		amountField.setColumns(30);
		amountField.addActionListener(handler);
		jl = new JLabel("Balance: " + df.format(user.getBalance()*6.72));
		JLabel jl2 = new JLabel("Please enter an amount in YUAN: ");
		JPanel textPanel = new JPanel();
		JPanel entryPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JButton dismiss = new JButton(DISMISS);
		dismiss.addActionListener(handler);
		JButton withdraw = new JButton(WITHDRAW_YUAN);
		withdraw.addActionListener(handler);
		JButton deposit = new JButton(DEPOSIT_YUAN);
		deposit.addActionListener(handler);
		
		textPanel.add(jl, null);
		textPanel.add(jl2, null);
		entryPanel.add((amountField), null);
		buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
		buttonPanel.add(deposit, null);
		buttonPanel.add(withdraw, null);
		buttonPanel.add(dismiss, null);
		this.getContentPane().add(textPanel, BorderLayout.NORTH);
		this.getContentPane().add(entryPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		this.setAlwaysOnTop(true);
		pack();
	}

	/* (non-Javadoc)
	 * @see simpleAccount.model.ModelListener#modelChanged(simpleAccount.model.ModelEvent)
	 */
	public void modelChanged(ModelEvent event) {
		jl.setText("Balance: " + df.format(event.getAmount()*6.47));
		amountField.setValue(0.00);
	}
	
	/**
	 * The Class Handler.
	 */
	public class Handler implements ActionListener {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == DISMISS)
				dispose();
			else
			{
				amount = Double.parseDouble(amountField.getValue().toString());
				((SimpleAccountController) getController()).operation(e.getActionCommand(), user, amount);
			}
		}
	}
}