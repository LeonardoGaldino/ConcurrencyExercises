package firstsPrimes;

import java.util.List;

public class Worker implements Runnable {
	
	CentralUnity central;
	
	public Worker(CentralUnity central) {
		this.central = central;
	}
	
	public void run() {
		int n = this.central.getLimit();
		List<Boolean> isPrime = this.central.getList();
		while(true) {
			try {
				int factor = this.central.getNextFactor();
				for(int i = factor*factor ; i <= n ; i += factor) {
					isPrime.set(i, false);
				}
			} catch (Exception e) {
				break;
			}
		}
	}
}
