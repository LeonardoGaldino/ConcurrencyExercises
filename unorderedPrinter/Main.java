package unorderedPrinter;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Inputs
		int numThreads = 2;
		int minNumber = 32;
		int maxNumber = 36;
		
		// Control Variables
		int numPrints = (maxNumber - minNumber + 1);
		int workLoad = numPrints/numThreads;
		int workLeft = numPrints%numThreads;
		List<Thread> threads = new ArrayList<Thread>();
		
		// Threads launch
		int curStart = minNumber;
		for(int i = 0 ; i < numThreads ; ++i) {
			Printer curPrinter = new Printer(curStart, curStart+workLoad-1);
			Thread curThread = new Thread(curPrinter);
			curThread.start();
			threads.add(curThread);
			curStart += workLoad;
		}
		
		// Work left thread start
		if(workLeft > 0) {
			Thread leftThread = new Thread(new Printer(curStart, maxNumber));
			leftThread.start();
			threads.add(leftThread);
			curStart = workLoad+1;
		}
		
		// Waits for threads to finish
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted.");
			}
		}
		
		System.out.println("All numbers printed!");
		
	}

}
