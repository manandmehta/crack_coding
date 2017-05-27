package tree_graph;

public class FirstCommonAncestor_4_8 {

	private static class TreeNode{
		TreeNode l;
		TreeNode r;
		int key;
		
		public TreeNode(int key){
			this.key = key;
		}
	}
	
	private static class Result{
		boolean found_p;
		boolean found_q;
		TreeNode commonAncestor;
		TreeNode sameparent;
		
		public Result(boolean found_p, boolean found_q){
			this.found_p = found_p;
			this.found_q = found_q;
		}
	}
	
	/**
	 * Find common ancestor without parent link 
	 * @param node
	 * @param p
	 * @param q
	 * @return
	 */
	private static Result findAncestor(TreeNode node, int p, int q, Result parent_r){
		
		if(node == null){
			return parent_r;
		}
		
		if(node.key == p || node.key == q){
			boolean pVal = node.key == p;
			boolean qVal = node.key ==q;
				
			parent_r = new Result(pVal,qVal);
			parent_r.sameparent = node;
		}
		
		// Go to left subtree and find p and q
		Result r_l = findAncestor(node.l,p,q, parent_r);
		
		if(r_l.commonAncestor != null){
			// Found ancestor no need to go further, just return back result
			return r_l;
		}
		
		// Go to right subtree and find p and q
		Result r_r = findAncestor(node.r,p,q, parent_r);
		
		if(r_r.commonAncestor != null){
			// Found ancestor no need to go further, just return back result
			return r_r;
		}
		
		// Compare what you received in left and right subtree
		// If this is node whose left subtree and right subtree found p and q, it is the common ancestor
		// We will stop recursion here by setting common ancestor and passing it forward
		Result r = new Result(r_l.found_p || r_r.found_p || parent_r.found_p, r_l.found_q || r_r.found_q || parent_r.found_q);
		if(r.found_p && r.found_q){
			r.commonAncestor = node;
		}
		return r;
	}
	
	
	////////////////////////////////////////////////////////////////////
	
	static TreeNode commonAncestor(TreeNode root, int p, int q){
		if(covers(root,p) == false || covers(root,q) == false){
			// The main root does not contain both the nodes
			return null; 
		}
		
		return ancestorHelper(root, p , q);
	}
	
	private static TreeNode ancestorHelper(TreeNode root, int p, int q){
		
		if( root == null || root.key == p || root.key == q){
			return root;
		}
		
		boolean pOnLeft = covers(root.l, p);
		boolean qOnLeft = covers(root.l, q);
		
		if(pOnLeft != qOnLeft){
			// p and q are on different sides
			return root;
		}
		
		TreeNode side = pOnLeft && qOnLeft ? root.l : root.r;
		
		return ancestorHelper(side, p, q);
	}
	
	
	private static boolean  covers(TreeNode root, int p){
		if(root == null){
			return false;
		}
		
		if(root.key == p){
			return true;
		}
		
		return covers(root.l, p) || covers(root.r, p);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(20);
		TreeNode t2 = new TreeNode(10);
		TreeNode t3 = new TreeNode(30);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(15);
		TreeNode t6 = new TreeNode(3);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(17);
		
		t1.l = t2;
		t1.r = t3;
		t2.l = t4;
		t2.r = t5;
		t4.l = t6;
		t4.r = t7;
		t5.r = t8;
		
		//Result r = findAncestor(t1,10,7, new Result(false, false));
		//if(r.commonAncestor == null){
		//	System.out.println("NO common ancestor");
		//}else{
		//	System.out.println(r.commonAncestor.key);
		//}

		
		TreeNode t = commonAncestor(t1,17,7);
		System.out.println(t.key);
		
		
	}
	
}
