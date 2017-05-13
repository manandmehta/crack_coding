package sorting;

public class Search_in_rotated_10_3 {
	private static int findOffset(int a[], int start, int end){
		int mid = (start+end) /2 ;
		
		if(a[start] <= a[mid] && a[mid] <= a[end]){
			return start;
		}
		
		if (a[start] <= a[mid]){
			// The pivot point is on the right
			return findOffset(a,mid+1,end);
		}else{
			// The pivot point is on the left
			return findOffset (a, start, mid);
		}
	}
	
	
	private static int binarySearch(int a[], int start, int end, int val , int offset, int len){
		if(start > end){
			return -1;
		}
		
		int mid = (start + end) / 2;
		int mid_offset = offset(mid,offset,len); 
		
		if(a[mid_offset] == val){
			return mid_offset; // Mistake -> Send the offset not the actual mid
		}
		
		if(a[mid_offset] < val ){
			return binarySearch(a,mid+1,end,val, offset,len);
		}else{
			return binarySearch(a,start,mid-1,val, offset,len);
		}
	}
	
	/**
	 * Using where the array is actually starting treat array as sorted only
	 * [4,5,1,2,3] -> offset index -> [1,2,3,4,5]
	 * 	offset = 3
	 *  length = 5
	 *  
	 *  offset_index of 2 = (2 + 3) % 5 = 0
	 *  
	 * @param index Index we want to offset with 
	 * @param offset  offset of starting of sorted array
	 * @param len length of array
	 * @return
	 */
	private static int offset(int index, int offset , int len){
		offset =  (index + offset ) %len;
		return offset;
	}
	
	public static void main(String[] args) {
		int a[] = new int[]{5,7,10,14,15,16,19,20,25,26,27,29,31,0,1,3,4};
		
		int offset =  findOffset(a,0,a.length-1);
		
		System.out.println(binarySearch(a,0,a.length-1,31,offset,a.length));
	}
}
