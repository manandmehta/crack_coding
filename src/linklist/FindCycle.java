package linklist;

public class FindCycle {

	/*
	 * Definition for singly-linked list.
	 */
	private static class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	}
	 
	public static ListNode detectCycle(ListNode a) {
	    if(a == null){
	        return null;
	    }
	    
	    ListNode slowRunner = a;
	    ListNode fastRunner = a; // Will move with 2x speed
	    
	    while(fastRunner.next != null && fastRunner.next.next != null){
	        slowRunner = slowRunner.next;
	        fastRunner = fastRunner.next.next;
	        
	        if(slowRunner== fastRunner){
	        	break;
	        }
	    }
	    
	    // If fastRunner hit end of list, there is not cycle
	    if(fastRunner.next == null || fastRunner.next.next == null){
	        return null;
	    }
	    
	    //slowRunner and fastRunner collided 
	    slowRunner = a;
	    while(slowRunner != fastRunner){
	        slowRunner = slowRunner.next;
	        fastRunner = fastRunner.next;
	    }
	    
	    return slowRunner;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l4;
		
		System.out.println(FindCycle.detectCycle(l1).val);
	}
}
