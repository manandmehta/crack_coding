package dynamic_recurse;

public class Recursive_multiply_8_5 {
	private static int multiply(int low, int high){
		if(low == 1){
			return high;
		}
		
		int sum = multiply(low-1,high);
		return sum + high;
	}
	
	
	
	private static int minProduct_notEfficient(int small, int big){
		if(small == 0){
			return 0;
		}else if(small == 1){
			return big;
		}
		
		int s = small >> 1; // divide by 2
		
		int side1 = minProduct_notEfficient(s,big);
		int side2 = side1;
		if(small %2 == 1){
			side2 = minProduct_notEfficient(small-s , big);
		}
		
		return side1 + side2;
	}
	
	private static int minProduct(int small, int big){
		if(small == 1){
			return big; // 1 * big = big
		}else if(small == 0){
			return 0;
		}
		
		// Divide the number by two
		int half = small >> 1;
		
		// This is half the sum we are looking for
		int oneSide = minProduct(half,big);
		
		if(small %2 == 0){
			// If the sum we computed for was even we just double our answer
			return oneSide + oneSide;
		}else{
			// For odd numbers, we rounded off the number by one hence we will add one more big number
			// E.g. 3 * 9 = [(9 + 9) + 9]
			return oneSide + oneSide + big;
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(multiply(7,9));
		//System.out.println(multiply_nonRecursive(7,9));
		//System.out.println(minProduct_notEfficient(6,9));
		System.out.println(minProduct(6,9));
	}
	
}
