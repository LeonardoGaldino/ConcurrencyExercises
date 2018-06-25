package prodCons;

import java.util.Queue;

public class Consumer implements Runnable {
	
	private Queue<Integer> itemsQueue;
	
	public Consumer(Queue<Integer> itemsQueue) {
		this.itemsQueue = itemsQueue;
	}
	
	private void consume() {
		Integer item = this.itemsQueue.poll();
		System.out.println("Consuming item: " + item);
	}
	
	public void run() {
		while(true) {
			synchronized(this.itemsQueue) {
				if(this.itemsQueue.isEmpty()) {
					try {
						System.out.println("Start waiting");
						this.itemsQueue.wait();
						System.out.println("Stop waiting");
						this.consume();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				} else
					this.consume();	
			}
		}
	}
}
