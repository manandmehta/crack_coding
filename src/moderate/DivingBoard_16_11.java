package moderate;

import java.util.HashSet;

public class DivingBoard_16_11 {

	private static HashSet <Integer> allLengths(int k, int small, int large){
		HashSet<Integer> allLengthSet = new HashSet<Integer>();
		
		/*
		 * Building size of 4 with length 1 and 3
		 * 1 1 1 1    length = 4
		 * 1 1 1 3    length = 6
		 * 1 1 3 3    length = 8
		 * 1 3 3 3    length = 10
		 * 3 3 3 3    length = 12
		 */
		int numSmall = k;
		int numLarge = 0;
		for(int i = 0 ; i <= k ; i++){
			int length = numSmall * small + numLarge * large;
			numSmall--;
			numLarge++;
			allLengthSet.add(length);
		}
		
		return allLengthSet;
	} 
	
	public static void main(String[] args) {
		HashSet<Integer> lengthSet =  allLengths(5,1,3);
		
		for (Integer length : lengthSet) {
			System.out.println(length);
		}
	}
}
