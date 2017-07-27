package edu.txstate.conBankBad;

/**
 This program runs two threads that deposit and withdraw
 money from the same bank account
*/
public class BankAccountTester
{
 /**
 Creates and runs threads for depositing and withdrawing to and from a
 bank account.
 @param args unused
 */
	
 public static void main(String[] args)
 {
	 BankAccount account = new BankAccount();
	 DepositAgent r0 = new DepositAgent(account,100);
	 Thread t0 = new Thread(r0);
	 t0.start();
	 WithdrawAgent r1 = new WithdrawAgent(account, 200);
	 Thread t1 = new Thread(r1);
	 t1.start();
	 System.out.println("Final balance: " + account.getBalance());
 }
 
}