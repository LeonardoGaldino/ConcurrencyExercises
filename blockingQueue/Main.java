package blockingQueue;

public class Main {
	
	public static void main(String[] args) {
		BlockingQueue queue = new BlockingQueue(3);
		Producer prod = new Producer(queue, 2);
		Consumer cons = new Consumer(queue, 2);
		(new Thread(prod)).start();
		(new Thread(cons)).start();
	}

}
