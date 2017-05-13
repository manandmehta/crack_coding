package bit_manip;

public class Missing_Int_10_7 {

	private static byte bitVec[];
	
	private static void prepareBitVector(int val[]){
		// Captures all positive integers
		bitVec = new byte[Integer.MAX_VALUE/8];
		
		for(int n : val){
			int index = n/8;  		// E.g. 10 will be at index 1
			int bitLocation = n%8;  // E.g. 10 will be at bit location 2
			
			bitVec[index] |= (1 << (bitLocation));  
		}
	}
	
	
	private static int getNextInt(){
		for (int i = 0 ; i < bitVec.length ; i ++){
			for(int j = 0 ; j < 8 ; j ++){
				if((bitVec[i] & (1<<j)) == 0){
					int num = (i * 8) + j ;
					return num;
				} 
			}
		}
		
		// All numbers are used
		return -1;
	}
	
	public static void main(String[] args) {
		int num[] = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,22,23,24,25,26,27,28,29};
		
		prepareBitVector(num);
		
		System.out.println(getNextInt());
	}
	
}
