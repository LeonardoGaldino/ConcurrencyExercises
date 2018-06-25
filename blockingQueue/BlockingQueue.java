package blockingQueue;

import java.util.concurrent.locks.*;
import java.util.LinkedList;

public class BlockingQueue {
	
	private int capacity;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition putCond = lock.newCondition();
	private final Condition takeCond = lock.newCondition();
	
	private LinkedList<Integer> container = new LinkedList<Integer>();
	
	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public void put(int value) {
		this.lock.lock();
		try {
			while(this.container.size() >= this.capacity)
				putCond.await();
			this.container.addLast(value);
			this.takeCond.signalAll();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
	
	public int take() {
		this.lock.lock();
		try {
			while(this.container.size() <= 0)
				takeCond.await();
			int head = this.container.getFirst();
			this.container.removeFirst();
			this.putCond.signalAll();
			return head;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			this.lock.unlock();
		}
	}
	
	

}
