Q1: Explanation for the race condition without synchronization
	Without synchronization, the OS simple schedules each individual thread as it deems appropriate,
	which leads to various errors depending on the order of which they are scheduled.

Q2: Explanation on how you fix the race condition
	With Locks and a Condition, we are able to await() for "hasFunds" to signal the awaiting threads
	in withdrawal, at which point they continue on and withdraw the funds (now that there are some).
	

Q3: Explanation on why the final balance is printed as 0.0 and a strategy to fix that
	Though the threads run independently, the main() function is still sequential in nature,
	thus the final line of main() is to print out the balance, after all the threads
	have been created and started. As each thread has a sleep() for 1 and 10, main() reaches the
	end of its instructions before the threads have completed.
	STRATEGY:
		The simplest solution is to join all threads together prior to the output of
		the final balance, which I have provided in the code (commented).

Jordan Williamson
jw1762