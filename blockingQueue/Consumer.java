package blockingQueue;

public class Consumer implements Runnable {
	
	private BlockingQueue queue;
	private int takes;
	
	public Consumer(BlockingQueue qu, int takes) {
		this.queue = qu;
		this.takes = takes;
	}
	
	public void run() {
		while(this.takes > 0) {
			System.out.println("Taking");
			int taken = this.queue.take();
			System.out.println("Taken: " + taken);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			--this.takes;
		}
		System.out.println("Producer shutdown");
	}
	
	
}

