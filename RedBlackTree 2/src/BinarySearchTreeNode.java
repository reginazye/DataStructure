
public class BinarySearchTreeNode<Object>{
	
	protected Integer data;
	protected BinarySearchTreeNode left;
	protected BinarySearchTreeNode right;
	protected BinarySearchTreeNode parent;
	
	public BinarySearchTreeNode(){

	}
	
	public BinarySearchTreeNode(Integer i) {
		data = i;
	}
	

	public void setData(Integer integer) {
		this.data = integer;		
	}
	
	public Integer getData(){
		return data;
	}

	/**
	 * insert a node 
	 * 
	 * @param integer
	 */
	public void insert(Integer integer) {
		if (integer.compareTo((Integer) this.data)<0 && this.left!=null){
				this.left.insert(integer);
		}
		else if (integer.compareTo((Integer) data)>=0 && this.right!=null){
				this.left.insert(integer);
		}
		if (integer.compareTo((Integer)this.data)<0){
			BinarySearchTreeNode nNode = new BinarySearchTreeNode(integer);
			this.left = nNode;
			nNode.parent = this;
		}
		if (integer.compareTo((Integer)this.data)>=0){
			BinarySearchTreeNode nNode = new BinarySearchTreeNode(integer);
			this.right = nNode;
			nNode.parent = this;
		}
		
	}

	/**
	 * get the left child 
	 * @return
	 */
	public BinarySearchTreeNode getLeft() {
		return this.left;
	}

	/**
	 * get the right child 
	 * @return
	 */
	public BinarySearchTreeNode getRight() {
		return this.right;
	}

	/**
	 * search for its parent 
	 * @param integer
	 * @return
	 */
	public BinarySearchTreeNode search(Integer integer) {
		if (this.data.equals(integer)){
			return this;
		}
		if (this.data.compareTo(integer)<0){
			if (this.right!=null)
			return this.right.search(integer);
		}
		if (this.data.compareTo(integer)>0){
			if (this.left!=null)
			return this.left.search(integer);
		}
		return null;
	}

	/**
	 * set left node 
	 * @param dataNode
	 */
	public void setLeft(BinarySearchTreeNode dataNode) {
		this.left = dataNode;
	}

	/**
	 * set right node
	 * @param testNode
	 */
	public void setRight(BinarySearchTreeNode testNode) {
		this.right = testNode;
	}

	/**
	 * get parent node 
	 * @return
	 */
	public BinarySearchTreeNode getParent(){
		return this.parent;
	}
	
	/**
	 * set parent node 
	 * @param anotherNode
	 */
	public void setParent(BinarySearchTreeNode anotherNode){
		this.parent = anotherNode;
	}


	
	
}
