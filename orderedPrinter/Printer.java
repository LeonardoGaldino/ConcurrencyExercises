package orderedPrinter;

public class Printer implements Runnable {

	NumberFactory numberFactory;

	public Printer(NumberFactory numberFactory) {
		this.numberFactory = numberFactory;
	}

	public void run() {
		while(true) {
			try {
				System.out.println(this.numberFactory.getNext());
			} catch(Exception e) {
				break;
			}
		}
	}
}