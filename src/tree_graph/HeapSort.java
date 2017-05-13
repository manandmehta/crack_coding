package tree_graph;

class HeapSort{
	
	int heap[];
	int length = 0;
		
	public int[] heapSort(int a[]){
		heap = new int[a.length];
	
		for(int i = 0 ; i < a.length; i++){
			buildHeap(a[i]);
		}
		
		int b[] = new int[a.length];
		
		for(int i = 0 ;i < a.length; i++){
			b[i] = extractMin();
		}
		
		return b;
	}
		
	private void buildHeap(int n){
		// Add right most child and call heapify down
		heap[length] = n;
		heapifyUp(length);
		length ++;
	}
	
	private void heapifyUp(int i){
		int parent = (i-1)/2;
		
		while(parent >= 0 && i > 0){
			if(heap[i] < heap[parent]){
				int temp = heap[i];
				heap[i] = heap[parent];
				heap[parent] = temp;
			}else{
				break;
			}
			i = parent;
			parent = (i-1)/2;
		}
	}
	
	private int extractMin(){
		int min =  heap[0];
		heap[0] = 	heap[length-1];
		length--;
		heapifyDown(0);
		return min;
	}
	
	private void heapifyDown(int i){
		int left = (2*i ) + 1;
		int right = (2*i ) + 2;
	
		while( (left < length && heap[left] < heap[i]) 
			||  (right < length && heap[right] < heap[i]) ){
				
				int swap = -1;
				
				if(right < length && heap[right] < heap[left]){
					swap = right;
				}else{
					swap = left;
				}
				
				int temp = heap[swap];
				heap[swap] = heap[i];
				heap[i] = temp;
				
				i = swap;
				left = (2*i ) + 1;
				right = (2*i ) + 2;
			
			}
	}
	
	public static void main(String[] args) {
		int a[] = {1,9,2,3,7,1,6,5,8,4,2,3,1};
		int b[] = new HeapSort().heapSort(a);
		for(int n : b){
			System.out.print(" " + n);
		}
	}
}