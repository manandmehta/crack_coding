package tree_graph;

import java.util.ArrayList;
import java.util.List;

/*
 * For a given binary tree create link list for each level
 * 
 * */


public class ListForLevel {


	 private static class Link{
		int data;
		Link next;
		public Link(int data){
			this.data = data;
		}
	}

	 private static class Node{
		boolean newLevelNode = false;
		int data;
		Node leftChild;
		Node rightChild;
		
		public Node(int data){
			this.data = data;
		}
	}

	
	private static List<Link> myBFSwrong(Node root){
		List <Link> headList = new ArrayList<Link>();
		
		if(root == null){
			return headList;
		}
		
		int index = 0 ;
		int queueindex = 1;
		
		List <Node> bfs = new ArrayList<Node>();
		root.newLevelNode = true;
		Link head = null;
		bfs.add(root);
		
		while(index < queueindex){
			Node n = bfs.get(index);
			
			if(n.newLevelNode){
				head = new Link(n.data);
				headList.add(head);
			}else{
				head.next = new Link(n.data);
				head = head.next;
			}
			
			// Mark the beginning of new level of tree by creating new head
			if(n.newLevelNode == true){
				if(n.leftChild != null){
					n.leftChild.newLevelNode = true;
				}else if(n.rightChild != null){
					n.rightChild.newLevelNode = true;
				}
			}
					
			if(n.leftChild !=null){
				bfs.add(n.leftChild);
				queueindex ++;
			}
	
			if(n.rightChild != null){
				bfs.add(n.rightChild);
				queueindex ++;
			}
			
			index ++;
		}
		return headList;
	}
	
	private static List<Link> myBFS(Node root){
		List <Link> headList = new ArrayList<Link>();
		
		if(root == null){
			return headList;
		}
		
		List <Node> parentList = new ArrayList<Node>();
		root.newLevelNode = true;
		parentList.add(root);
		
		while(parentList.isEmpty() == false){
			Link head = null;
			// Transform a level in link list
			for(Node n : parentList){
				if(head == null){
					head = new Link(n.data);
					headList.add(head);
				}else{
					head.next = new Link(n.data);
					head = head.next;
				}
			}
			
			List <Node> childList = new ArrayList<Node>(); 
			for(Node n : parentList){
				if(n.leftChild != null){
					childList.add(n.leftChild);
				}
				if(n.rightChild != null){
					childList.add(n.rightChild);
				}
			}

			parentList = childList;
		}
		return headList;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node l2_1 = new Node(2);
		Node l2_2 = new Node(3);
		Node l3_1 = new Node(4);
		Node l3_2 = new Node(5);
		Node l3_3 = new Node(6);
		Node l3_4 = new Node(7);
		root.leftChild = l2_1;
		root.rightChild = l2_2;
		l2_1.leftChild = l3_1;
		l2_1.rightChild = l3_2;
		l2_2.leftChild = l3_3;
		l2_2.rightChild = l3_4;
		
		/*
		 *    1
		 *   2
		 * 3
		 * */
//		Node root = new Node(1);
//		Node l2_1 = new Node(2);
//		Node l3_1 = new Node(3);
//		root.leftChild = l2_1;
//		l2_1.leftChild = l3_1;

		/*
		 *     1
		 *   2
		 *     3 
		 * */
//		Node root = new Node(1);
//		Node l2_1 = new Node(2);
//		Node l3_1 = new Node(3);
//		root.leftChild = l2_1;
//		l2_1.rightChild = l3_1;
		
		/*
		 *     1
		 *       2
		 *         3 
		 * */
		
//		Node root = new Node(1);
//		Node l2_1 = new Node(2);
//		Node l3_1 = new Node(3);
//		root.rightChild = l2_1;
//		l2_1.rightChild = l3_1;
		
		/*
		 *     1
		 *   2   3
		 *     4   5 
		 * */
		
//		Node root = new Node(1);
//		Node l2_1 = new Node(2);
//		Node l2_2 = new Node(3);
//		Node l3_1 = new Node(4);
//		Node l3_2 = new Node(5);
//				
//		root.leftChild = l2_1;
//		root.rightChild = l2_2;
//		l2_2.leftChild = l3_1;
//		l2_2.rightChild = l3_2;
		
		List<Link> head= myBFS(root);
		
		for (Link link : head) {
			while(link != null){
				System.out.print(link.data + " ");
				link = link.next;
			}
			System.out.println();
		}
		
	}
}
