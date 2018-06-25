package countDown;

public class Main {
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(100);
		Worker w1 = new Worker(latch, 1);
		Worker w2 = new Worker(latch, 2);
		Worker w3 = new Worker(latch, 3);
		Worker w4 = new Worker(latch, 4);
		Worker w5 = new Worker(latch, 5);
		Worker w6 = new Worker(latch, 6);
		(new Thread(w1)).start();
		(new Thread(w2)).start();
		(new Thread(w3)).start();
		(new Thread(w4)).start();
		(new Thread(w5)).start();
		(new Thread(w6)).start();
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Latch currently: " + latch.getCounter());
	}

}
