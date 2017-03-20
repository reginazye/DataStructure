
public class BinarySearchTree {

	public BinarySearchTreeNode root;

	public BinarySearchTree(BinarySearchTreeNode binarySearchTreeNode) {
		root = binarySearchTreeNode;
	}

	public BinarySearchTree() {
		root = new BinarySearchTreeNode();
	}

	public BinarySearchTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinarySearchTreeNode bstn){
		root = bstn;
	}
	public void insert(Integer integer) {
		root.insert(integer);
	}

	public BinarySearchTreeNode search(Integer integer) {
		return root.search(integer);
	}

	
	}
	
	


