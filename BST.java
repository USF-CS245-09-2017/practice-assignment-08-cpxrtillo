public class BST<T>{
	private BSTNode root; // depth of root is 0, depth of root is 

	public BST() {
		root = null;
	}

	// take smallest thing on right subtree, take that, and push it up to that value until you find the child's child
	public Comparable removeSmallest(BSTNode node) {
		if (node.get_Left().get_Left() == null) {
			Comparable smallest = node.get_Left().get_Info();
			node.set_Left(node.get_Left().get_Right());
			return smallest;
		}
		else {
			return removeSmallest(node.get_Left());
		}
	}

	public void delete(Comparable value){
        root = delete(root, value);
    }

	public BSTNode delete(BSTNode node, Comparable value) { // between O(n and log n)
		// replace with inorder successor --> most common; to do it, find leftmost node on the right subtree
		// replace with inorder predecessor

		// if node not found in tree, return null
		if (node == null) {
			return null;
		}

		// cover 0 children or one child on the right, one child on the left
		if (node.get_Info().compareTo(value) == 0) {
			if (node.get_Left() == null)
				return node.get_Right();
			else if (node.get_Right() == null) {
				return node.get_Left();
			}
			else { // take it's data, adopt child
				if (node.get_Right().get_Left() == null) {
					node.set_Info(node.get_Right().get_Info());
					node.set_Right(node.get_Right().get_Right());
					return node;
				}
				else {
					node.set_Info(removeSmallest(node.get_Right()));
					return node;
				}
			}
		} // make sure** left or right deletion
		else if (node.get_Info().compareTo(value) < 0) {
			node.set_Left(delete(node.get_Left(), value));
		}
		else {
			node.set_Right(delete(node.get_Right(), value));
		}
		return node;
	}

	public void insert(Comparable value) { // between O(n and log n)
		root = insert(root, value);
	}
	
	// insert node at a specific position
	private BSTNode insert(BSTNode node, Comparable value){ //O()
		if(node == null){
		    BSTNode n = new BSTNode(value);
		    return n;
		}
		else if(node.get_Info().compareTo(value) < 0){
		    BSTNode n = insert(node.get_Right(), value);
		    node.set_Right(n);
		}
		else{
		    BSTNode n = insert(node.get_Left(), value);
		    node.set_Left(n);
		}
		return node;
	}

	public boolean find(Comparable value) {
		return find(root, value);
	}
	
	// recursively find value we are looking for
	private boolean find(BSTNode node, Comparable value) { // between O(n and log n)

		if (node == null) {
			return false;
		}

		if (node.get_Info().compareTo(value) == 0) {
			return true;
		}
		else if (node.get_Info().compareTo(value) < 0) {
			return find(node.get_Right(), value);
		}
		else {
			return find(node.get_Left(), value);
		}
	}

	public void print(){
        print(root);
    }
	// print system
	public void print(BSTNode node) { // O(n)
		if (node != null) {
			print(node.get_Left());
			System.out.println(node.get_Info());
			print(node.get_Right());
		}
	}
}
	
	class BSTNode<T> {
	Comparable data;
	BSTNode left;
	BSTNode right;

	public BSTNode(Comparable value){
		this.data = value;
		left = null;
		right = null;
	}

	public void set_Right(BSTNode value){
		this.right = value;
	}

	public BSTNode get_Left(){
		return this.left;
	}

	public void set_Info(Comparable value){
		this.data = value;
	}

	public Comparable get_Info(){
		return this.data;
	}

	public void set_Left(BSTNode value){
		this.left = value;
	}

	public BSTNode get_Right(){
		return this.right;
	}
}
