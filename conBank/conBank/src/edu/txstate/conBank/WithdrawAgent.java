package edu.txstate.conBank;
public class WithdrawAgent implements Runnable
{
	private BankAccount agent;
	private int wVal;

	public WithdrawAgent(BankAccount account, int value) 
	{
		this.agent = account;
		this.wVal = value;
	}
	
	public void run() 
	{
		try {
			Thread.sleep(1);
			agent.withdraw(wVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Withdraw agent thread running...");
	}
}