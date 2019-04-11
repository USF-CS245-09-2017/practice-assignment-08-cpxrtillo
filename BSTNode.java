public class BSTNode<T> {
	protected Comparable data;
	protected BSTNode left;
	protected BSTNode right;

	public BSTNode(Comparable value){
		this.data = value;
		left = null;
		right = null;
	}

	public void setRight(BSTNode value){
		this.right = value;
	}

	public BSTNode getLeft(){
		return this.left;
	}

	public void setData(Comparable value){
		this.data = value;
	}

	public Comparable getData(){
		return this.data;
	}

	public void setLeft(BSTNode v){
		this.left = v;
	}

	public BSTNode getRight(){
		return this.right;
	}
}