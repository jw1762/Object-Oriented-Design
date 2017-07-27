package edu.txstate.conBank;
import java.util.ArrayList;
import java.util.List;

public class BankAccountTester
{
 /**
 Creates and runs threads for depositing and withdrawing to and from a
 bank account.
 @param args unused
 * @throws InterruptedException 
 */
 public static void main(String[] args) throws InterruptedException
 {
	 List<Thread> threads = new ArrayList<Thread>();
	 
	 BankAccount account = new BankAccount();
	 DepositAgent r0 = new DepositAgent(account,100);
	 Thread t0 = new Thread(r0);
	 t0.start();
	 threads.add(t0);
	 
	 WithdrawAgent r1 = new WithdrawAgent(account, 200);
	 Thread t1 = new Thread(r1);
	 t1.start();
	 threads.add(t1);
	 
	 DepositAgent r2 = new DepositAgent(account,100);
	 Thread t2 = new Thread(r2);
	 t2.start();
	 threads.add(t2);
	 
	 DepositAgent r4 = new DepositAgent(account,100);
	 Thread t4 = new Thread(r4);
	 t4.start();
	 threads.add(t4);
	 
	 WithdrawAgent r3 = new WithdrawAgent(account, 200);
	 Thread t3 = new Thread(r3);
	 t3.start();
	 threads.add(t3); 	

	 DepositAgent r5 = new DepositAgent(account,100);
	 Thread t5 = new Thread(r5);
	 t5.start();
	 threads.add(t5);
	 
	 DepositAgent r6 = new DepositAgent(account,100);
	 Thread t6 = new Thread(r6);
	 t6.start();
	 threads.add(t6);
	 
	 //Comment-out loop for "final0.jpg" style result.
	  
	 for(Thread T: threads)
	 {
		 T.join();
	 }
	 
	 System.out.println("Final balance: " + account.getBalance());
 }
}