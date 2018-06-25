package q4_2017_2;

public class Semaforo {
	
	private Integer counter;
	
	public Semaforo() {
		this.counter = 0;
	}
	
	public void up() {
		synchronized(this.counter) {
			++this.counter;
			if(this.counter == 1)
				this.counter.notifyAll();
		}
	}
	
	public void down() {
		synchronized(this.counter) {
			while(this.counter == 0) {
				try {
					this.counter.wait();
				} catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			--this.counter;
		}
	}

}
