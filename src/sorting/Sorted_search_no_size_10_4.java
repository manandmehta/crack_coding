package sorting;

/*
 * Given array like data structure that is in sorted order find an element n's index
 * The size of the array is not known but you get back value -1 if you go out of bound
 * */
public class Sorted_search_no_size_10_4 {
	
	private static int binarySearch(int a[], int start, int end, int val){
		if(start > end){
			return -1;
		}
		
		int mid = (start + end) /2;
		
		if(a[mid] ==  val){
			return mid;
		}
		
		if(a[mid] > val){
			return binarySearch(a,start,mid-1,val);
		}else{
			return binarySearch(a,mid+1,end,val);
		}
	}
	
	

	/**
	 * Given array of non negative and negative values, find index of last non-negative value
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	private static int find(int a[], int start, int end){
		if(start > end){
			return start-1;
		}
		
		int mid = (start + end)/2;
		
		if(a[mid] < 0){ 
			// We hit out bound of array  
			return find(a,start,mid-1);  // Mistake: Forgot to put return here
		}else{
			return find(a,mid+1,end);    // Mistake: Forgot to put return here
		}
	}
	
	/**
	 * Find the first negative or bigger number than val in the list
	 * If bigger number than val is found, we will treat that as end of array
	 * If bigger -1 number found, use find function to find last non negative number and treat that as end of array
	 * proceed with binary search from this point
	 * @param a
	 * @param val
	 * @return
	 */
	private static int findIndex(int a[],  int val){
		boolean foundBig = false;
		boolean foundNegative = false;
		
		if(a[0] == val){
			return 0;
		}
		
		// Value does not exist in array
		if(a[0] > val){
			return -1;
		}
		
		int index = 1;
		while(foundBig == false && foundNegative == false){
			if(a[index] == val){
				return index;
			}
			
			if(a[index] > val){
				foundBig = true;
				break;
			}
			else if(a[index] < 0){
				foundNegative = true;
				break;
			}
			
			index = index * 2;
		}
		
		int start = 0;
		
		if(foundBig){
			// The first element (>val) we encountered in the array, we will treat it as end of array
			return binarySearch(a,start,index,val);
		}else{
			// Using the first -1 we encountered, find out the last non negative integer in array
			index = find(a,start,index);
			
			// Same treatment as of foundBig from this point
			return binarySearch(a,start,index,val);
		}
		
	}
	
	public static void main(String[] args) {
		int a[] = {0,1,2,3,4,5,6,7,8,9,10,11,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
				,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
				,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		
		System.out.println(findIndex(a, 4));
	}
}
