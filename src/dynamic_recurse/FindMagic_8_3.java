package dynamic_recurse;

public class FindMagic_8_3 {

	private static int findMagic(int a[],int start, int end){
		if(start > end){
			return -1;
		}
		
		int mid = (start + end) /2;
		
		if(a[mid] == mid){
			return mid;
		}
		
		/**
		 * E.g. a[5] = 13
		 * We know that a[6] is at least 13 hence it cannot be magic index.
		 * Similarly any number from a[6] to a[12] cannot be magic index
		 */
		if(a[mid] > mid){
			// Search left half as it is
			int magic_num = findMagic(a,start,mid-1);
			if(magic_num == -1){
				// If left half could  not find magic number, look to right side
				magic_num = findMagic(a,a[mid],end);
			}
			return magic_num;
		}
		/**
		 * E.g. a[10] = 3
		 * We know that a[9] is at least 3 hence it could not be magic index
		 * Similarly the only number that can be magic index is a[3] = 3
		 */
		else{
			// Search right half as it is
			int magic_num = findMagic(a,start,a[mid]);
			if(magic_num == -1){
				magic_num = findMagic(a,mid+1,end);
			}
			return magic_num;
		}
	}
	
	public static void main(String[] args) {
		int a[] = new int[]{1,2,8,8,11,11,12,12,12,12,12,12,13,13,19,21,27}; 
		System.out.println(findMagic(a,0,a.length-1));
	}
	
}
