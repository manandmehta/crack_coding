package moderate;

public class Operations_16_9 {

	private static int flipSign(int num){
		/**
		 * If number is 50, we want -50  (Need to add -100, or Add -1 100 times)
		 * If number is -50 we want 50   (Need to add 100, or Add 1 100 times)
		 */
		
		if(num == 0){return 0;}
		
		int addConst = num > 0 ? -1 : 1;
		
		// We need to add 1 or -1 this many times
		int delta = Math.abs(num) + Math.abs(num);
		
		int flipNumber = num; 
		
		int progression = addConst;
		
		/**
		 * We need to reduce the size of delta, hence we must maintain negative progression
		 */
		int negativeProgression = -1;  
		
		while(delta != 0){
			
			// Take double the hop
			progression = progression + progression;
			negativeProgression = negativeProgression + negativeProgression;
			
			if(delta + negativeProgression < 0){
				// We cannot make this big of hop
				negativeProgression = -1;
				progression = addConst; 
			}
			
			delta = delta + negativeProgression;
			flipNumber = flipNumber + progression;
		}
		
		/* We cannot use below as we are not allowed to use ~ operator
		num = (~num + 1); // Flip the sign bit
		*/ 
		return flipNumber;
	}
	
	private static int subtract(int a, int b){
		return a + flipSign(b);
	}
	
	private static int mul (int a, int b){
		boolean positive = true; 
		
		// Only of one of the number is negative, our answer will be negative
		if( (a <0 && b >= 0) || (b <0 && a >= 0)){
			positive = false;
		}
		
		// Get absolute values of a and b
		a = Math.abs(a);
		b = Math.abs(b);
		
		int small, big;
		if(a > b){
			big = a; small = b;
		}else{
			big = b; small = a;
		}
		
		int mul = 0 ;
		int index = 0 ;
		while(index < small){
			mul = mul + big;
			index ++;
		}
			
		if(positive == false){
			mul = flipSign(mul);
		}
		return mul;
	}
	
	private static int divide (int a , int b) throws ArithmeticException{
		if(b == 0){
			throw new ArithmeticException("Divide by zero error");
		}
		
		boolean positive = true; 
		
		// Only of one of the number is negative, our answer will be negative
		if( (a <0 && b >= 0) || (b <0 && a >= 0)){
			positive = false;
		}
		
		a = Math.abs(a);
		b = Math.abs(b);
		int x = 0;
		int multiplication = b;
		
		/**
		 * 6/3 =>   6 = 3x    a = bx 
		 * We add 3 to it until we reach answer 
		 */
		
		while(multiplication <= a){
			multiplication = multiplication + b;
			x++;
		}
		
		if(positive){
			return x;
		}else{
			return flipSign(x);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(mul(5,7));
		System.out.println(subtract(6,3));
		System.out.println(divide(1000,2));
		//System.out.println(flipSign(10));
	}
}
