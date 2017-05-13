package tree_graph;

/**
 * Problem: 4.2 Minimal Tree
 * Given sorted array, write algorithm to crate binary search tree with minimal height.
 * @author mdmehta
 */

public class PrepareTree{

	public static void main(String args []){
		int ary[] = new int[]{1,2,3,4,5,6,7,8,9,10,11};
		
		Node root = PrepareTree.createTree(ary,0,ary.length-1);
		
		PrepareTree.inOrderTraverse(root);
		
	}

	public static void inOrderTraverse(Node n){
		if(n!=null){
			inOrderTraverse(n.left);
			System.out.println(n.data +" ");
			inOrderTraverse(n.right);
		}
	}
	
	
//	public static void printTree(Node n){
//		int index =  0;
//		ArrayList<Node> bfslist = new ArrayList<Node>();
//		bfsList.add(n);
//		
//		while(index <= bfsList.size()){
//			Node n = bfsList[index];
//			System.out.println("  "+n.data);
//			
//			if(n.left != null){
//				bfsList.add(n.left);
//			}
//			if(n.right != null){
//				bfsList.add(n.right);
//			}
//			
//			index++;
//		}
//	}


	public static Node createTree(int ary[],int start, int end){
		if(ary ==null || ary.length ==0){
			return null;
		}
		if(start == end){
			return new Node(ary[start]);
		}
		
		/**
		 * For border nodes the start and end will go outside of size range
		 * For internal nodes, the start will become bigger than end for termination
		 */
		if(end < 0 || start >= ary.length || start > end){
			return null;
		}
		
		int mid = (start+end)/2;
		
		Node root = new Node(ary[mid]);
		root.left = createTree(ary,start,mid-1);
		root.right = createTree(ary,mid+1,end);
		return root;
	}
}


class Node{
	public Node left;
	public Node right;
	public int data;
	
	public Node(int data){
		this.data = data;
	}
}
