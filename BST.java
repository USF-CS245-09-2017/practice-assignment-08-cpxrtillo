public class BST<T>{
	private BSTNode root; // depth of root is 0, depth of root is 

	public BST() {
		root = null;
	}

	public boolean find(Comparable value) {
		return find(root, value);
	}

	private boolean find(BSTNod node, Comparable value) { // between O(n and log n)

		if (node == null) {
			return false;
		}

		if (node.getInfo().compareTo(value) == 0) {
			return true;
		}
		else if (node.getInfo().compareTo(value) > 0) {
			return find(node.getRight(), value);
		}
		else {
			return find(node.getLeft(), value);
		}
	}

	public void insert(Comparable value) { // between O(n and log n)
		root = insert(root, value);
	}

	private BSTNode insert(BSTNode node, Comparable value) {
		if (node == null) {
			BSTNode n = new BSTNode(value);
			return n;
		}
		else if (node.getInfo().compareTo(value) > 0) {
			BSTNode n = insert(node.getLeft(), value);
			node.setLeft(n);
			return node;
		}
		else {
			BSTNode n = insert(node.getRight(), value);
			node.setRight(n);
			return node;		
		}
	}

	// take smallest thing on right subtree, take that, and push it up to that value until you find the child's child
	public Comparable removeSmallest(BSTNode node) {
		if (node.getLeft().getLeft() == null) {
			Comparable smallest = node.getLeft().getInfo();
			node.setLeft(node.getLeft().getRight());
			return smallest;
		}
		else {
			return removeSmallest(node.getLeft());
		}
	}

	public void print(){
        print(root);
    }

	public void print(BSTNode node) { // O(n)
		if (node != null) {
			print(node.getLeft());
			System.out.println(node.getInfo());
			print(node.getRight());
		}
	}

	// public void delete(Comparable value){
 //        root = delete(root, value);
 //    }

	// public BSTNode delete(BSTNode node, Comparable value) { // between O(n and log n)
	// 	// replace with inorder successor --> most common; to do it, find leftmost node on the right subtree
	// 	// replace with inorder predecessor

	// 	// if node not found in tree, return null
	// 	if (node == null) {
	// 		return null;
	// 	}

	// 	// cover 0 children or one child on the right, one child on the left
	// 	if (node.getInfo().compareTo(value) == 0) {
	// 		if (node.getLeft() == null)
	// 			return node.getRight();
	// 		else if (node.getRight() == null) {
	// 			return node.getLeft();
	// 		}
	// 		else { // take it's data, adopt child
	// 			if (node.getRight().getLeft() == null) {
	// 				node.setInfo() = node.getRight().getInfo();
	// 				node.setRight() = node.getRight().getRight();
	// 				return node;
	// 			}
	// 			else {
	// 				node.setInfo() = removeSmallest(node.getRight());
	// 				return node;
	// 			}
	// 		}
	// 	} // make sure** left or right deletion
	// 	else if (node.getInfo().compareTo(value) < 0) {
	// 		node.setLeft() = delete(node.getLeft(), value);
	// 	}
	// 	else {
	// 		node.setRight() = delete(node.getRight().getInfo(), value);
	// 	}
	// }
}
