package unorderedPrinter;

public class Printer implements Runnable {
	
	int start;
	int end;
	
	public Printer(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		for(int i = start ; i <= end ; ++i)
			System.out.println(i);
	}
}
