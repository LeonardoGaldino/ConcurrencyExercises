package q1_2017_2;

public class Account {
	
	private Integer balance;
	
	public Account() {
		this.balance = 0;
	}
	
	public boolean withdraw(int amount, int tid) {
		synchronized(this.balance) {
			if(this.balance >= amount) {
				this.balance -= amount;
				System.out.println(tid + ": Success to withdraw " + amount + " | Balance : " + this.balance);
				return true;
			}
			System.out.println(tid + ": Failed to withdraw " +amount + " | Balance : " + this.balance);
			// Not enough cash to withdraw
			return false;
		}
	}
	
	public void deposit(int value, int tid) {
		synchronized(this.balance) {
			this.balance += value;
			System.out.println(tid + ": Deposit " + value + " | Balance : " + this.balance);
		}
	}
	
	public int getBalance() {
		return this.balance;
	}

}
