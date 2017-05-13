package tree_graph;


/**
 * @author mdmehta
 * 4.5 Validate if the binary tree is BST or not
 * If we do inorder traversal at every point we should encounter bigger element in our traversal 
 */
public class ValidateBST {
	private int prevNum = -1;
	private  boolean bst = true;
	private boolean didGoRight = false;
	
	private void inOrder(Node n, boolean goingleft){
		if(n != null && bst){
			
			if(didGoRight == false && goingleft == false){
				didGoRight = true;
			}
			
			inOrder(n.left,true);
			visit(n);
			inOrder(n.right,false);
		}
		
	}
	
	private void visit(Node n){
		if(didGoRight){
			if(n.data <= prevNum){
				bst = false;
			}
		}else{
			if(n.data < prevNum){
				bst = false;
			}
		}
		
		didGoRight = false; // Reset the flag
		prevNum = n.data;
	}
	
	private static class Node{
		public Node(int data) {
			this.data = data;
		}
		Node left;
		Node right;
		int data;
	} 
	
	public static void main(String[] args) {
		
		ValidateBST vBST = new ValidateBST();
		vBST.inOrder(getTree1(),true);
		System.out.println( "Tree 1 "+ vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree2(),true);
		System.out.println( "Tree 2 "+vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree3(),true);
		System.out.println( "Tree 3 "+vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree4(),true);
		System.out.println( "Tree 4 "+vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree5(),true);
		System.out.println( "Tree 5 "+vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree6(),true);
		System.out.println( "Tree 6 "+vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree7(),true);
		System.out.println( "Tree 7 "+vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree8(),true);
		System.out.println( "Tree 8 "+vBST.bst);
		
		vBST = new ValidateBST();
		vBST.inOrder(getTree8(),true);
		System.out.println( "Tree 9 "+vBST.bst);
		
	}
	
	private static Node getTree1(){
		/*
		 * This is not BST
		 *     2
		 *   2   2
		 *   
		 * */
		Node root = new Node(2);
		Node l2_1 = new Node(2);
		Node l2_2 = new Node(2);
		root.left = l2_1;
		root.right = l2_2;
		return root;
	}
	
	private static Node getTree2(){
		/*
		 * This is BST
		 *     2
		 *   2   
		 * 2  
		 * */
		Node root = new Node(2);
		Node l2_1 = new Node(2);
		Node l3_1 = new Node(2);
		root.left = l2_1;
		l2_1.left = l3_1;
		return root;
	}
	
	private static Node getTree3(){
		/*
				5
			3		9
		  2	  4   8   10
		 */
		Node root = new Node(5);
		Node l2_1 = new Node(3);
		Node l2_2 = new Node(9);
		Node l3_1 = new Node(2);
		Node l3_2 = new Node(4);
		Node l3_3 = new Node(8);
		Node l3_4 = new Node(10);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		return root;
	}
	
	private static Node getTree4(){
		/*
		 * Not BST
				5
			3		9
		  2	  4   5   10
		 */
		Node root = new Node(5);
		Node l2_1 = new Node(3);
		Node l2_2 = new Node(9);
		Node l3_1 = new Node(2);
		Node l3_2 = new Node(4);
		Node l3_3 = new Node(5);
		Node l3_4 = new Node(10);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		return root;
	}
	
	private static Node getTree5(){
		/*
		 *BST
				5
			3		9
		  2	  4   9   10
		 */
		Node root = new Node(5);
		Node l2_1 = new Node(3);
		Node l2_2 = new Node(9);
		Node l3_1 = new Node(2);
		Node l3_2 = new Node(4);
		Node l3_3 = new Node(9);
		Node l3_4 = new Node(10);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		return root;
	}
	
	private static Node getTree6(){
		/*
		 *NOT  BST
				5
			3		9
		  2	  4   8   10
		    2
		 */
		Node root = new Node(5);
		Node l2_1 = new Node(3);
		Node l2_2 = new Node(9);
		Node l3_1 = new Node(2);
		Node l3_2 = new Node(4);
		Node l3_3 = new Node(8);
		Node l3_4 = new Node(10);
		Node l4_1 = new Node(2);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		l3_1.right = l4_1;
		return root;
	}
	
	private static Node getTree7(){
		/*
		 * BST
				5
			3		9
		  2	  4   8   10
	    2    
		 */
		Node root = new Node(5);
		Node l2_1 = new Node(3);
		Node l2_2 = new Node(9);
		Node l3_1 = new Node(2);
		Node l3_2 = new Node(4);
		Node l3_3 = new Node(8);
		Node l3_4 = new Node(10);
		Node l4_1 = new Node(2);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		l3_1.left = l4_1;
		return root;
	}
	
	private static Node getTree8(){
		/*
		 * NOT BST
				5
			3		9
		  2	  4   8   10
	    2   2 
		 */
		Node root = new Node(5);
		Node l2_1 = new Node(3);
		Node l2_2 = new Node(9);
		Node l3_1 = new Node(2);
		Node l3_2 = new Node(4);
		Node l3_3 = new Node(8);
		Node l3_4 = new Node(10);
		Node l4_1 = new Node(2);
		Node l4_2 = new Node(2);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.left = l3_1;
		l2_1.right = l3_2;
		l2_2.left = l3_3;
		l2_2.right = l3_4;
		l3_1.left = l4_1;
		l3_1.right = l4_2;
		return root;
	}
	
	private static Node getTree9(){
		/*
		 * NOT BST
			   20	
			10	 30
		       25
		 */
		Node root = new Node(20);
		Node l2_1 = new Node(10);
		Node l2_2 = new Node(30);
		Node l3_1 = new Node(25);
		root.left = l2_1;
		root.right = l2_2;
		l2_1.right = l3_1;
		return root;
	}
}
