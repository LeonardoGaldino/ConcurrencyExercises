package orderedPrinter;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Inputs
		int numThreads = 5;
		int minNumber  = 1;
		int maxNumber  = 100;
		
		// Control Variables
		NumberFactory numberFactory = new NumberFactory(minNumber, maxNumber);
		List<Thread> threads = new ArrayList<Thread>();
		
		// Threads launch
		for(int i = 0 ; i < numThreads ; ++i) {
			Printer curPrinter = new Printer(numberFactory);
			Thread curThread = new Thread(curPrinter);
			curThread.start();
			threads.add(curThread);
		}

		// Waits for threads to finish
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.getStackTrace();
			}
		}
		
		System.out.println("All numbers printed!");
		
	}

}
