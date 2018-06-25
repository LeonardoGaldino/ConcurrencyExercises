package q2_2017_2;

import java.util.concurrent.atomic.*;

public class Account {
	
	private AtomicInteger balance;
	
	public Account() {
		this.balance = new AtomicInteger(0);
	}
	
	public boolean withdraw(int amount, int tid) {
		int curBalance = this.balance.get();
		if(curBalance >= amount) {
			this.balance.compareAndSet(curBalance, curBalance-amount);
			System.out.println(tid + ": Success to withdraw " + amount + " | Balance : " + this.balance.get());
			return true;
		}
		System.out.println(tid + ": Failed to withdraw " +amount + " | Balance : " + this.balance.get());
		// Not enough cash to withdraw
		return false;
	}
	
	public void deposit(int value, int tid) {
		this.balance.addAndGet(value);
		System.out.println(tid + ": Deposit " + value + " | Balance : " + this.balance.get());
	}
	
	public int getBalance() {
		return this.balance.get();
	}

}
