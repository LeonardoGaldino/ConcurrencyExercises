package firstsPrimes;

import java.util.List;
import java.util.ArrayList;

public class CentralUnity {

	private int n;
	private int nextFactor;
	private List<Boolean> isPrime;
	
	public CentralUnity(int n) {
		this.n = n;
		this.nextFactor = 2;
		this.isPrime = new ArrayList<Boolean>();
		this.isPrime.add(false); // 0 not prime
		this.isPrime.add(false); // 1 not prime
		for(int i = 2 ; i <= n ; ++i)
			this.isPrime.add(true);
	}
	
	public List<Boolean> getList() {
		return this.isPrime;
	}
	
	public int getLimit() {
		return this.n;
	}
	
	public synchronized int getNextFactor() throws Exception {
		if(nextFactor <= Math.sqrt(n))
			return nextFactor++;
		throw new Exception("Limit exceeded");
	}
	
	
}
