package blockingQueue;

public class Producer implements Runnable {
	
	private BlockingQueue queue;
	private int insertions;
	
	public Producer(BlockingQueue qu, int insertions) {
		this.queue = qu;
		this.insertions = insertions;
	}
	
	public void run() {
		while(this.insertions > 0) {
			int value = (int)(Math.random()*100);
			System.out.println("Trying to put " + value);
			this.queue.put(value);
			System.out.println(value + " put.");
			try {
				Thread.sleep(5000);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			--this.insertions;
		}
		System.out.println("Consumer shutdown");
	}

}