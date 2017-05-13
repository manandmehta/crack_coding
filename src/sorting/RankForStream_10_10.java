package sorting;

/**
 * You are being fed random integers from stream you need to implement structure
 * that gives rank of number at ant given time
 * Rank of number = # of smaller or equal to elements 
 * @author mdmehta
 */
public class RankForStream_10_10 {
	
	private static class Node{
		int data;
		Node l;
		Node r;
		int l_node_count;
		
		public Node(int data){
			this.data = data;
			l_node_count = 0;
		}
	}
	
	Node root;
	
	private void insertNode(int val){
		if(root == null){
			root = new Node(val);
			return;
		}
		
		addNode(root, val);
	}
	
	/**
	 * Find out the node under whom we will insert the given node
	 * If we are going to insert in  left subtree, we increment the l_node_count 
	 */
	private void addNode(Node n, int val){
		if(n.data >= val){
			// If node is being inserted to left subtree, we increase the count
			n.l_node_count ++;
			
			if(n.l == null){
				n.l = new Node(val);
				return;
			}else{
				addNode(n.l, val);
			}
		}else{
			// For right sub tree, we do not need to maintain the numbers for smaller elements
			if(n.r == null){
				n.r = new Node(val);
				return;
			}else{
				addNode(n.r,val);
			}
		}
	}
	
	private int findRank(Node n, int val){
		if(n == null){
			return -1; // Node does not exist in tree
		}
		
		if(n.data == val){
			// on this node, all left subtree nodes are smaller or equal to current val
			return n.l_node_count;
		}
		
		if(val > n.data){
			int count = findRank(n.r, val);
			if(count == -1){
				return -1; // Not does not exist
			}
			
			/**
			 * In recursion we just came back visiting right sub tree
			 * Hence, all nodes in left subtree and the current node (counted as +1) are smaller than val
			 */
			return count + 1 + n.l_node_count;
		}else{
			int count = findRank(n.l, val);
			/**
			 * Noting special here, if we went to left subtree the value of node is smaller than current node value
			 */
			return count;
		}
	}
	
	
	public static void main(String[] args) {
		int a[] = {25,35,15,10,20,30,10,17,23,32};
		
		RankForStream_10_10 rs = new RankForStream_10_10();
		
		for (int val : a) {
			rs.insertNode(val);
		}
		
		for (int val : a) {
			System.out.println(val +" Rank > "+rs.findRank(rs.root, val));
		}
		
	}
	
}
