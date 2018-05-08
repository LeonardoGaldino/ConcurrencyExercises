package concurrentCounter;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

// Leading to basic concurrency problem
// Experimenting how many iterations needed to reach a concurrency problem

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Number of threads: ");
		int numThreads = in.nextInt();
		System.out.print("Limit number: ");
		int limit = in.nextInt();
		int times = 0;
		while(true) {
			Counter counter = new Counter(0);

			List<Thread> threads = new LinkedList<Thread>();
			for(int i = 0 ; i < numThreads ; ++i) {
				Worker curWorker = new Worker(i, limit, counter);
				Thread curThread = new Thread(curWorker);
				curThread.start();
				threads.add(curThread);
			}

			for(Thread thread : threads) {
				try {
					thread.join();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			System.out.println("Done: " + counter.current);
			if(counter.current != numThreads*limit)
				break;
			++times;
		}
		System.out.println(times + " Times successfully executed.");
		in.close();
	}

}
