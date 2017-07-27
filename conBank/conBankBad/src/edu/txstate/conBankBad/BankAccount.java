package edu.txstate.conBankBad;

public class BankAccount
{
/**
 A bank account has a balance that can be changed by
 deposits and withdrawals.
*/
private double balance;
 /**
 Constructs a bank account with a zero balance
 */
public BankAccount()
{
	balance = 0;
}

 /**
 Deposits money into the bank account.
 @param amount the amount to deposit
 */
public void deposit(double amount)
{
	System.out.print("Depositing " + amount);
	balance = balance + amount;
	System.out.println(", new balance is " + balance);
}

 /**
 Withdraws money from the bank account.
 @param amount the amount to withdraw
 */
public void withdraw(double amount)
{
	System.out.print("Withdrawing " + amount);
	balance = balance - amount;
	System.out.println("in withdraw, new balance is " + balance);
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