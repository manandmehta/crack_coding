package linklist;

public class Palindrome {

	private static class Result{
		boolean isPelindrome;
		Node n;
		
		public Result(boolean isPelindrome, Node n){
			this.isPelindrome = isPelindrome;
			this.n = n;
		}
	}
	
	private static class Node{
		Node next;
		int data;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	private int findLen(Node n){
		int len = 0 ;
		while( n != null){
			n = n.next;
			len++;
		}
		return len;
	}
	
	/**
	 * We will strategies to return matching element of palindrome for comparison
	 * 1    2    3    4    5    6
 	 * a -> b -> c -> c -> b -> a
	 * We will return 
	 * 			element 4 to compare in element 3's recursion
	 * 			element 5 to compare in element 2's recursion and so on
	 * 
	 * @param n
	 * @param index
	 * @param size
	 * @return
	 */
	private Result isPelindrome(Node n, int index, int size){
		if(size == 1){
			return new Result(true,null);
		}
		
		if(index > (size/2)){
			// For odd length list, we will skip element at center (e.g. skip c in a->c->a)
			Node mid = (size%2==0)? n : n.next;
			return new Result(true,mid);
		}
		
		// MISTAKE : CANNOT USE index++ here
		Result r = isPelindrome(n.next,index+1,size);
		
		// If we came across element that was not palindrome, we will just return back result
		if(!r.isPelindrome){
			return r;
		}
		
		if(r.n.data != n.data){
			return new Result(false,n.next);
		}
		
		return new Result(true,r.n.next);
	}
	
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		
		Node n1 = new Node(1);
		Node n2 = new Node(2); n1.next = n2;
		Node n3 = new Node(3); n2.next = n3;
		Node n4 = new Node(4); n3.next = n4;
		Node n5 = new Node(3); n4.next = n5;
		Node n6 = new Node(2); n5.next = n6;
		Node n7 = new Node(1); n6.next = n7;

//		Node n1 = new Node(1);
//		Node n2 = new Node(2); n1.next = n2;
//		Node n3 = new Node(3); n2.next = n3;
//		Node n4 = new Node(3); n3.next = n4;
//		Node n5 = new Node(2); n4.next = n5;
//		Node n6 = new Node(1); n5.next = n6;
		
//		Node n1 = new Node(1);
//		Node n2 = new Node(1); n1.next = n2;

//		Node n1 = new Node(1);
//		Node n2 = new Node(2); n1.next = n2;
//		Node n3 = new Node(3); n2.next = n3;
//		Node n4 = new Node(4); n3.next = n4;
//		Node n5 = new Node(2); n4.next = n5;
//		Node n6 = new Node(2); n5.next = n6;
//		Node n7 = new Node(1); n6.next = n7;
		
		Result r = p.isPelindrome(n1,1,p.findLen(n1));
		System.out.println(r.isPelindrome);

		
		
	}
}
