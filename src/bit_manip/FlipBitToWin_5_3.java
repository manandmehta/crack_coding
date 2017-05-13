package bit_manip;

/**
 * @author mdmehta
 * Flip only single 0 -> 1 and find max sequence of 1s
 * 
 * E.g. 11011101111    => Answer is 8
 *
 */
public class FlipBitToWin_5_3 {

	private static int maxLenFlip(int n){
		int curLen = 0 ; 
		int prevLen = 0;
		int max = 1;
		
		if(~n == 0){
			/* If all 1s no we are at max already */
			return Integer.BYTES * 8;
		}
		
		while(n != 0){
			if((n & 1) == 1){
				// Current bit is 1
				curLen++;
			}else{
				prevLen = curLen;
				curLen = 0;
			}
			
			max = Integer.max(max, (curLen + prevLen + 1));
			
			/*
			 * Keep shifting bits to right so we can loop through all bits
			 */
			n = n>>>1;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		//int N = Integer.parseInt("11011101111", 2);
		//int N = Integer.parseInt("11011101110011", 2);
		int N = Integer.parseInt("110011", 2);
		
		int max = maxLenFlip(N);
		
		System.out.println(max);
	}
}
