package concurrentCounter;

public class Worker implements Runnable {
	
	int limit;
	int tid;
	Counter counter;

	public Worker(int tid, int limit, Counter counter) {
		this.tid = tid;
		this.limit = limit;
		this.counter = counter;
	}

	public void run() {
		for(int i = 0 ; i < this.limit ; ++i)
			System.out.println(tid + ": " + (counter.current++));
	}
}
