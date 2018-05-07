package orderedPrinter;

public class NumberFactory {

	int start;
	int end;
	int current;

	public NumberFactory(int start, int end) {
		this.start = this.current = start;
		this.end = end;
	}

	public synchronized int getNext() throws Exception {
		if(this.current <= end)
			return this.current++;
		throw new Exception("No more numbers to be printed");
	}
}