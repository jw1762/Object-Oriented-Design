package edu.txstate.conBank;
public class DepositAgent implements Runnable
{
	private int dVal;
	private BankAccount agent;

	public DepositAgent(BankAccount account, int value) 
	{
		this.agent = account;
		this.dVal = value;
	}

	public void run()
	{
		try {
			Thread.sleep(10);
			agent.deposit(dVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Deposit agent thread running...");
	}

}
