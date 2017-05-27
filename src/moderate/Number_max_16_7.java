package moderate;

import javafx.scene.control.SplitPane.Divider;

public class Number_max_16_7 {

	/**
	 * Does not work for negative numbers
	 * @param a
	 * @param b
	 */
	private static void findNumberMax(int a, int b){
		
		try{
			int sum = (a/b) / (a/b);
			System.out.println(a);
		}catch(java.lang.ArithmeticException ex){
			//ex.printStackTrace();
			System.out.println(b);
		}
	}

	
	/**
	 * Flip the first bit at position 0
	 * @param n
	 * @return
	 */
	private static int flip(int bit){
		return bit ^ 1;
	}
	
	/**
	 * Find sign of Integer
	 * @return 1 : If number >= 0
	 * 		   0   If number < 0	
	 */
	private static int findSign(int n){
		// 32 th bit represents sign 
		// If 1 -> The number is negative
		// If 0 -> The number is positive
		int sign = n >>> 31;
		return flip(sign);
	}
	
	private static void findMax(int a, int b){
		
		/**
		 * The goal we are trying to achieve is
		 * if(a>b)
		 * 	k = 1
		 *  q = 0
		 * if(b > a)
		 * 	k = 0
		 * 	q = 1
		 *   
		 * Answer = a * k + b * q  
		 * 
		 */
		
		int diff = a-b;
		int kDiffSign = findSign(diff);

		// If aSign and bSign are different, we may cause Integer overflow
		int aSign = findSign(a);  // 1 if a >= 0 , 0 otherwise
		int bSign = findSign(b);  // 1 if b >= 0 , 0 otherwise
		int k_sign = aSign ^ bSign;  // k_sign = 1 (when a and b are different sign, 0 otherwise)
		int k_signFlip = flip(k_sign);
		
		// If a and b are of different sign => k_sign = 1  k_signFlip = 0
		// If a and b are same, k_sign will be 0, we will use kDiffSign as answer 
		int k = (k_sign *  aSign)+ (k_signFlip * kDiffSign);
		int q = flip(k);
		
		int maxNumber = k * a + q*b;
		System.out.println(maxNumber);
	}
	
	public static void main(String[] args) {
//		System.out.println(findSign(5));
//		System.out.println(findSign(-5));
		
		findMax(15,5);
		findMax(5,15);
		findMax(-5,-15);
		findMax(-25,-15);
		findMax(Integer.MAX_VALUE,-15);
		findMax(Integer.MIN_VALUE,15);
	}
	
}
