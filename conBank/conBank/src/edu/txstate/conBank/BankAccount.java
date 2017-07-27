package edu.txstate.conBank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
/**
 A bank account has a balance that can be changed by
 deposits and withdrawals.
*/
private double balance;
private final Lock changeLock;
private Condition hasFunds;

 /**
 Constructs a bank account with a zero balance
 */
 public BankAccount()
 {
	 balance = 0;
	 changeLock = new ReentrantLock();
	 hasFunds = changeLock.newCondition();
 }
 /**
 Deposits money into the bank account.
 @param amount the amount to deposit
 */
 public void deposit(double amount)
 {
	 changeLock.lock();
	 try{
	 System.out.print("Depositing " + amount);	
	 balance = balance + amount;
	 hasFunds.signalAll();
	 
	 System.out.println(", new balance is " + balance);
	 }
	 finally{
	 changeLock.unlock();
	 }
}

 /**
 Withdraws money from the bank account.
 @param amount the amount to withdraw
 */
public void withdraw(double amount)
{
	changeLock.lock();
	try{
	System.out.print("Withdrawing " + amount + " ");
	
	if(balance < amount)
	{
		System.out.print("blocked\n");	
	}
	
	while (balance < amount)
	{
		hasFunds.await();
	}	
	
	if (balance >= amount)
	{
		balance = balance - amount; 
	}
	hasFunds.signalAll();
	System.out.println("in withdraw, new balance is " + balance);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	finally{
		changeLock.unlock();
	}
}

 /**
 Gets the current balance of the bank account.
 @return the current balance
 */
 public double getBalance()
 {
 return balance;
 }

}
/**
 This program runs two threads that deposit and withdraw
 money from the same bank account
*/