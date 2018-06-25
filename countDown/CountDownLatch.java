package countDown;

import java.util.concurrent.locks.*;

public class CountDownLatch {
	
	private int counter;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();
	
	public CountDownLatch(int start) {
		this.counter = start;
	}
	
	public void await() {
		this.lock.lock();
		try {
			this.cond.await();
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
	
	public boolean countDown() {
		this.lock.lock();
		try {
			if(this.counter > 0) {
				--this.counter;
				if(this.counter == 0) {
					this.cond.signalAll();
				}
				return true;
			}
			return false;	
		} finally {
			this.lock.unlock();
		}
	}
	
	public int getCounter() {
		return this.counter;
	}

}
