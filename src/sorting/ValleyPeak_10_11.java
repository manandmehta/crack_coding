package sorting;

/**
 * Objective is to print the array in valley, peak style (Like a saw)
 * The way we can do this if the middle element is always bigger in pairs of three
 * @author mdmehta
 */
public class ValleyPeak_10_11 {

	private static void sortValleyPeak(int a[]){
		for(int i = 1; i < a.length ; i += 2){
			int biggestIndex = maxIndex(a,i-1,i,i+1);
			// We want to go from peak to peak
			if (i != biggestIndex){
				// swap
				int temp = a[i];
				a[i] = a[biggestIndex];
				a[biggestIndex] = temp;
			}
			
			/**
			 * Note: Swapping on right is ok as it will get fixed as we move forward but
			 * we may worry that when we swap to left, we might break our existing setup.
			 * However, if you think on left the element is already smaller than its peak.
			 * We will only replace it if that left value is higher than current value,
			 * hence we will actually replace it with even a smaller value. 
			 * 
			 *   E.g.   1 11 8 6 5
			 *   Above, when we are 6, we will replace it with 8 but while doing that we will 
			 *   replace it with  even a smaller value, hence the peak 1 11 6 remains as it is
			 */
		}
	}
	
	private static int maxIndex(int ary[], int a, int b, int c){
		int aVal = a < 0 || a >= ary.length ? Integer.MIN_VALUE : ary[a];
		int bVal = b < 0 || b >= ary.length ? Integer.MIN_VALUE : ary[b];
		int cVal = c < 0 || c >= ary.length ? Integer.MIN_VALUE : ary[c];
		
		int maxval = Integer.max(aVal, Integer.max(bVal,cVal));
		
		if(maxval == aVal){
			return a;
		}else if(maxval ==bVal){
			return b;
		}else {
			return c;
		}
	}
	
	public static void main(String[] args) {
		int a[] = new int[]{5,9,6,3,7,1,3,2,4,1,3,6,0,2,1,4,5};
		sortValleyPeak(a);
		
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
