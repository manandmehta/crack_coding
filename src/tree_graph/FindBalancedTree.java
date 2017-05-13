package tree_graph;

/**
 * @author mdmehta
 * Given a tree find out if the tree is balanced or not. 
 * The idea is to do postOrder traversing (visit left, visit right , visit root)
 * and find depth of each sub tree. If at any point we notice difference of more than two in depth 
 * the tree is not balanced binary tree 
 */
public class FindBalancedTree {
	
	private static boolean not_balanced = false; 
	
	static int postOrder(Node node){
		if (node == null || not_balanced){
			// Either we found out that the tree is not balanced
			// or we already have hit leaf node 
			return 0;
		}
		
		int d_l = postOrder(node.left);
		int d_r = postOrder(node.right);
		
		int max_d = 0;
		if(d_l <= d_r){
			if(d_l + 2 <= d_r){
				not_balanced = true;
			}
			max_d = d_r;
		}else if(d_r <= d_l){
			if(d_r + 2 <= d_l){
				not_balanced = true;
			}
			max_d = d_l;
		}

		return max_d + 1;  // Increment by one for next level 
	}
	
	 private static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		not_balanced = false;
		postOrder(getTree1());
		System.out.println("Tree1 " + not_balanced);
		
		not_balanced = false;
		postOrder(getTree2());
		System.out.println("Tree2 " + not_balanced);
		
		not_balanced = false;
		postOrder(getTree3());
		System.out.println("Tree3 " + not_balanced);
		
		not_balanced = false;
		postOrder(getTree4());
		System.out.println("Tree4 " + not_balanced);
		
		not_balanced = false;
		postOrder(getTree5());
		System.out.println("Tree5 " + not_balanced);
		
		not_balanced = false;
		postOrder(getTree6()); 
		System.out.println("Tree6 " + not_balanced);
		
		not_balanced = false;
		postOrder(getTree7());
		System.out.println("Tree7 " + not_balanced);
		
		
	}
	
	private static Node getTree1(){
		/*
				1
			2		3
		  4	  5   6   7
		 */
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l2_2 = new Node(3);
		Node l3_1 = new Node(4);
		Node l3_2 = new Node(5);
		Node l3_3 = new Node(6);
		Node l3_4 = new Node(7);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		return root;
	}
	
	private static Node getTree2(){
		/*
		 *    1
		 *   2
		 * 3
		 * */
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l3_1 = new Node(3);
		root.left = l2_1;
		l2_1.left = l3_1;
		return root;
	}
	
	private static Node getTree3(){
		/*
		 *     1
		 *   2
		 *     3 
		 * */
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l3_1 = new Node(3);
		root.left = l2_1;
		l2_1.right = l3_1;
		return root;
	}
	
	private static Node getTree4(){
		
		/*
		 *     1
		 *       2
		 *         3 
		 * */
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l3_1 = new Node(3);
		root.right = l2_1;
		l2_1.right = l3_1;
		return root;
	}
	
	private  static Node getTree5(){
		/*
		 *     1
		 *   2   3
		 *     4   5 
		 * */
		
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l2_2 = new Node(3);
		Node l3_1 = new Node(4);
		Node l3_2 = new Node(5);
				
		root.left = l2_1;
		root.right = l2_2;
		l2_2.left = l3_1;
		l2_2.right = l3_2;
		return root;
	}
	
	private static Node getTree6(){
		/*
		 			1
		 		2		3
		 	  4	  5	  6
		    7
		 */
		
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l2_2 = new Node(3);
		Node l3_1 = new Node(4);
		Node l3_2 = new Node(5);
		Node l3_3 = new Node(6);
		Node l3_4 = new Node(7);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l3_1.left = l3_4;
		return root;
	}
	
	private static Node getTree7(){
		/*
		 			1
		 		2		3
		 	  	  4
		 	  	     5	  	  
		 */
		
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l2_2 = new Node(3);
		Node l3_1 = new Node(4);
		Node l4_1 = new Node(5);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.right = l3_1;
		l3_1.right = l4_1;
		return root;
	}
}
