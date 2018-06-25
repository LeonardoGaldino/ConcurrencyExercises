package prodCons;

import java.util.Queue;

public class Producer implements Runnable {
	
	private Queue<Integer> itemsQueue;
	
	public Producer(Queue<Integer> itemsQueue) {
		this.itemsQueue = itemsQueue;
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
				synchronized(this.itemsQueue) {
					int t = (int)(100*Math.random());
					this.itemsQueue.add(t);
					this.itemsQueue.notify();
				}
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
