package syncBST;

public class BST {

	public BSTNode root;
	public int size;

	public BST() {
		this.root = null;
		this.size = 0;
	}

	public void insert(int data) {
		
		synchronized (this) {
			++this.size;
			if(this.root == null) {
				this.root = new BSTNode(data);
				return;
			}
		}
		
		BSTNode curNode = this.root;
		while(true) {
			if(curNode.data > data) {

				if(curNode.left == null) {
					synchronized(curNode) {
						curNode.left = new BSTNode(data);
						return;
					}
				}

				curNode = curNode.left;
			}
			else {

				if(curNode.right == null) {
					synchronized(curNode) {
						curNode.right = new BSTNode(data);
						return;
					}
				}

				curNode = curNode.right;
			}
		}		
	}

}
