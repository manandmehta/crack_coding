package sorting;

public class Sparse_string_searching_10_4 {

	private static int binarySearch(String a[],int start, int end, String val){
		if(start > end){
			return -1;
		}
		
		int mid = (start + end) /2;
		
		if(a[mid].isEmpty()){
			// Fan out on both the sides and look for first non empty string
			int left = mid, right = mid;
			
			while(left >= start || right <= end){
				if(left >= start && a[left].isEmpty() == false){  // Mistake Forgot to check for left >= start
					mid = left;
					break;
				}
				if(right <= end && a[right].isEmpty() == false){ // Mistake Forgot to check for right <= end
					mid = right;
					break;
				}
				
				if(left >= start){
					left--;
				}
				if(right <= end){
					right ++;
				}
			}
		}
		
		// If we hit boundaries and mid is not initialized, the element does not exist in array
		if(a[mid].isEmpty()){
			return -1;
		}
		
		if(a[mid].equals(val)){
			return mid;
		}
		
		if(a[mid].compareTo(val) > 0){
			return binarySearch(a,start, mid-1, val);
		}else{
			return binarySearch(a,mid+1, end, val);
		}
	}
	
	public static void main(String[] args) {
		String a[] = {"a","","","","","","","b","","c","d","","","","","","","e","","","f",""};
					// 0  1  2  3  4  5  6   7   8  9  10  11 12 13 14 15 16 17  18 19  20 21    
 		System.out.println(binarySearch(a, 0, a.length-1, "a"));
		System.out.println(binarySearch(a, 0, a.length-1, "b"));
		System.out.println(binarySearch(a, 0, a.length-1, "c"));
		System.out.println(binarySearch(a, 0, a.length-1, "d"));
		System.out.println(binarySearch(a, 0, a.length-1, "e"));
		System.out.println(binarySearch(a, 0, a.length-1, "f"));
		System.out.println(binarySearch(a, 0, a.length-1, "z"));
		
		
//		0 21    10
//		0 9     4
//		8 9     8 
		
	}
	
}
