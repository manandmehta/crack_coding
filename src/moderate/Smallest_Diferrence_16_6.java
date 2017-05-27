package moderate;

import java.util.Arrays;

public class Smallest_Diferrence_16_6 {

	
	/**
	 * The binary search will return equal or the next closest element
	 * @param ary
	 * @param start
	 * @param end
	 * @param val
	 * @return
	 */
	private static int binarySearchClosestBigOrEqual(int ary[], int start, int end, int val){
		if(start >= end){
			return start;
		}
		
		int mid = (start + end) /2;
		
		if(ary[mid] == val){
			return mid;
		}
		
		if(ary[mid] < val){
			return binarySearchClosestBigOrEqual(ary,mid+1,end,val);
		}else{
			return binarySearchClosestBigOrEqual(ary,start,mid-1,val);
		}
	}
	
	private static int findClosestDiff(int a[], int b[]){
		Arrays.sort(a);
		Arrays.sort(b);
		
		int small[];
		int big[];
		
		if(a.length >= b.length){
			big = a;
			small = b;
		}else{
			small = a;
			big = b;
		}
		
		
		int minDiff = Integer.MAX_VALUE;
		
		for (int num : small) {
			int index = binarySearchClosestBigOrEqual(big,0, big.length -1 , num);
			
			if(big[index] == num){
				return 0; // We have a matching number, difference cannot be smaller than this
			}else if(big[index]> num){
				// We have the next biggest number
				if(big[index] - num < minDiff ){
					minDiff = big[index] - num;
				}
				
				// Try to find the next smallest number and find difference
				if(index-1 >= 0){
					if(num - big[index-1] < minDiff){
						minDiff = num - big[index-1];
					}
				}
			}else{
				// We have the next smaller number
				if(num - big[index] < minDiff){
					minDiff = num - big[index];
				}
				
				if(index + 1 < big.length){
					if(big[index + 1] - num < minDiff){
						minDiff = big[index + 1] - num;
					}
				}
			}
		}

			
		return minDiff;
	}
	
	public static void main(String[] args) {
		int a[] = new int[]{1,2,15,2};
		int b[] = new int[]{23,127,235,19,8};
		
		int closest = findClosestDiff(a,b);
		System.out.println(closest);
	}
	
}
