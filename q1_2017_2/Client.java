package q1_2017_2;

public class Client implements Runnable {

	private final int DEPOSIT = 0;
	private final int WITHDRAW = 1;
	
	private Account account;
	private int tid;
	
	public Client(Account account, int tid) {
		this.account = account;
		this.tid = tid;
	}
	
	// Sleep from 0 to 5 second
	private void randomSleep() {
		int timeSleep = (int)(Math.random()*5000);
		try {
			Thread.sleep(timeSleep);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public int depositOrWithdraw() {
		return (Math.random() > 0.5 ? this.WITHDRAW : this.DEPOSIT); 
	}
	
	public int randomValue() {
		return (int)(Math.random()*1000);
	}
	
	public void run() {
		while(true) {
			this.randomSleep();
			int action = depositOrWithdraw();
			if(action == this.DEPOSIT)
				this.account.deposit(this.randomValue(), this.tid);
			else if(action == this.WITHDRAW)
				this.account.withdraw(this.randomValue(), this.tid);
			
		}
	}
	
}
