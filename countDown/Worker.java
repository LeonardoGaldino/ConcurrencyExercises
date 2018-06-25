package countDown;

public class Worker implements Runnable {
	
	private CountDownLatch latch;
	private int tid;
	
	public Worker(CountDownLatch latch, int id) {
		this.latch = latch;
		this.tid = id;
	}
	
	public void run() {
		while(true) {
			int randomized = (int) (Math.random()*100.0);
			if(randomized > 5) {
				System.out.println(this.tid + ": Trying to decrement.");
				boolean decremented = this.latch.countDown();
				if(!decremented)
					break;
				else
					System.out.println(this.tid + ": Decrement success.");
			} else {
				if(this.latch.getCounter() > 0) {
					System.out.println(this.tid + ": Waiting.");
					this.latch.await();
					System.out.println(this.tid + ": Waiting end.");
				}
			}
		}
		System.out.println(this.tid + ": Decrement failed.");
	}

}
