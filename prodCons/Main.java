package prodCons;

import java.util.Queue;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.add(12);
		q.add(1);
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		new Thread(p).start();
		new Thread(c).start();
		
	}

}
