package tree_graph;


/**
 * @author mdmehta
 * Problem 4.6
 * Given binary tree, find its in-order successor
 */
public class FindSuccessor {
	private static class Node{
		public Node(int data) {
			this.data = data;
		}
		Node left;
		Node right;
		Node parent;
		int data;
	} 
	
	static Node findSuccessor(Node n){
		
		// This node's right subtree exist, hence the successor is left most node in right sub tree 
		if(n.right != null){
			return findLeftMostNode(n.right);
		}
		
		// No right subtree, no parent, it must be root
		if(n.parent == null){
			return null;
		}
		
		// No right subtree, if node is parent's left node, its successor is parent itself 
		if(n.parent.left == n){
			return n.parent;
		}
		
		// No right subtree, if node is paren'ts right node, keep going up until parent is left child itself
		while(n.parent != null && n.parent.right == n ){
			n = n.parent;
		}
		
		return n.parent;
	}
	
	static Node findLeftMostNode(Node n){
		if(n.left == null){
			return n;
		}
		
		return findLeftMostNode(n.left);
	}
	
	public static void main(String[] args) {
		
				/*
				5
			3		9
		  2	  4   8   10
		1          
		*/
		Node root = new Node(5);
		Node l2_1 = new Node(3);
		Node l2_2 = new Node(9);
		root.left = l2_1;  
		l2_1.parent = root;
		root.right = l2_2;
		l2_2.parent = root;
		Node l3_1 = new Node(2);
		Node l3_2 = new Node(4);
		Node l3_3 = new Node(8);
		Node l3_4 = new Node(10);
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l3_1.parent = l2_1;
		l3_2.parent = l2_1;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		l3_3.parent = l2_2;
		l3_4.parent = l2_2;
		Node l4_1 = new Node(1);
		l3_1.left = l4_1;
		l4_1.parent = l3_1;
		
//		Node n = findSuccessor(l4_1);
//		System.out.println(n.data);
//		
//		n = findSuccessor(l3_1);
//		System.out.println(n.data);
//		
//		n = findSuccessor(l3_2);
//		System.out.println(n.data);
//		
//		n = findSuccessor(root);
//		System.out.println(n.data);
//		
//		n = findSuccessor(l3_3);
//		System.out.println(n.data);
		
		Node n = findSuccessor(l3_4);
		System.out.println(n.data);
	}
	
	
	
}
