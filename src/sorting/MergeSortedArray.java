package sorting;

public class MergeSortedArray {


	/*
		10.1 Given are two sorted arrays where a has large enough buffer at back to hold all elements of b
		move over all sorted elements to a
	*/
	static void mergeArray(int a[], int b[]){
		// Assuming the size of a has exactly b.length elements empty at the back 
		// We will shift down all elements a to its back 
	
		for(int i_move = a.length-1, i = (a.length - b.length)-1; i >= 0 ;i--,i_move-- ){
			// Shift elements to back of array
			a[i_move] = a[i];
		}
			
		
		for(int val : a){
			System.out.print(val + " ");
		}
		
		System.out.println();
		
		// Now just like merge sort merge two array
		int aindex = b.length;  
		int bindex = 0;
		int i = 0; 
		
		while(i < a.length){
			if(bindex >= b.length){
				a[i] = a[aindex];
				i++;
				aindex++;
			}else if(aindex >= a.length){
				a[i] = b[bindex];
				i++;
				bindex++;
			}else if( b[bindex] <= a[aindex]){
				a[i] = b[bindex];
				i++;
				bindex++;
			}else {
				a[i] = a[aindex];
				i++;
				aindex++;
			}
		}
		
		for(int val : a){
			System.out.print(val + " ");
		}
	}
	
	public static void main(String[] args) {
		int a [] = new int []{2,4,6,7,8,9,11,18,23,29,-1,-1,-1,-1};
		int b[] = new int []{1,3,5,34};
		
		mergeArray(a, b);
	}

	
}
