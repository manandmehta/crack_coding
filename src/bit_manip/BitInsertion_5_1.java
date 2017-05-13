package bit_manip;

/**
 * Insert M bit into N
 * @author mdmehta
 *
 */
public class BitInsertion_5_1 {

	private static int insertBits(int N, int M, int i, int j){
		// Step 1 
		// Negate ~0 to get all 1s and shift it j+1 times 
		int mask_l = ~0 << j+1;
		int mask_r = (1 << i)-1;
		
		// OR both mask to prepare final mask
		int mask = mask_l | mask_r;
		
		int n_cleared = mask & N;
		
		// Now shift M i bits
		int m_shifted = M << i;
		
		return n_cleared | m_shifted;
	}
	
	public static void main(String[] args) {
		int N = Integer.parseInt("10000000000", 2);
		int M = Integer.parseInt("10011", 2);;
		int i = 2; 
		int j = 6;
		
		int result = insertBits(N,M,i,j);
		
		String binaryStr = Integer.toBinaryString(result);
		
		System.out.println(binaryStr);
	}
}
