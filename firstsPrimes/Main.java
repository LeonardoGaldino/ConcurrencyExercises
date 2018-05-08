package firstsPrimes;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numThreads = 10;
		
		// Reads n which is the greatest possible prime in the list
		int n = in.nextInt();
		CentralUnity central = new CentralUnity(n);
		List<Thread> threads = new ArrayList<Thread>();
		
		// Launches threads
		for(int i = 0 ; i < numThreads ; ++i) {
			Worker curWorker = new Worker(central);
			Thread curThread = new Thread(curWorker);
			curThread.start();
			threads.add(curThread);
		}
		
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
		
		List<Integer> primes = new ArrayList<Integer>();
		List<Boolean> isPrime = central.getList();
		for(int i = 0 ; i < isPrime.size() ; ++i) {
			if(isPrime.get(i))
				primes.add(i);
		}
		
		for(Integer prime : primes) {
			System.out.println(prime);
		}
		
		in.close();
	}

}
