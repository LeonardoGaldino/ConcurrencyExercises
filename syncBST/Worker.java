package syncBST;

public class Worker implements Runnable {

	BST tree;
	int numInsertions;

	public Worker(BST tree, int numInsertions) {
		this.tree = tree;
		this.numInsertions = numInsertions;
	}

	public void run() {
		for(int i = 0 ; i < numInsertions ; ++i) {
			int c = (int)Math.floor(100*Math.random());
			this.tree.insert(c);
		}
	}
}
