package moderate;

public class FactorialZero_16_5 {
	
	/**
	 * Find number of trailing zeros in n!
	 * @param n
	 * @return
	 */
	private static int findTrailingFactZero(int n){
		int fiveCount = n/5; // Find factors of five
		int cubeCount = 0; 
		int fiveCube = 25;
		
		// Find five multiplicatives
		while(fiveCube <= n){
			fiveCube = 5 * fiveCube;
			cubeCount++;
		}
		
		/*
		  For 25 -> We need to count 5 twice
		  	  50 -> We need to count 5 twice (25 * 2)
		  	  125 -> We need to count 5 thrice
		 */
		fiveCube = 5;
		while(cubeCount > 0){
			fiveCube = fiveCube * 5;
			int occurence = n / fiveCube;
			fiveCount += (occurence * cubeCount);
			cubeCount--;
		}
		
		return fiveCount;
	}
	
	public static void main(String[] args) {
		System.out.println(findTrailingFactZero(1000));
	}
}
