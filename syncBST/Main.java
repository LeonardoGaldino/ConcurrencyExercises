package syncBST;

public class Main {

	public static void main(String[] args) {
		BST tree = new BST();
		Worker w1 = new Worker(tree, 100000);
		Worker w2 = new Worker(tree, 100000);
		Thread t1 = (new Thread(w1));
		Thread t2 = (new Thread(w2));
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(tree.root.data);
		System.out.println(tree.size);
	}

}
