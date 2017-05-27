package dynamic_recurse;

public class Coins_8_11 {
	
	private static int makeChange(int amount, int[] denoms, int index){
		if(index >= denoms.length - 1){
			return 1;
		}
		
		int denomAmount = denoms[index];
		int ways = 0;
		
		for(int i= 0 ; i * denomAmount <= amount ; i++){
			int amountRemaining = amount - (i * denomAmount);
			ways += makeChange(amountRemaining, denoms, index + 1);
		}
		
		return ways;
	} 
	
	private static int makeChangeDynamic(int amount, int[] denoms){
		int dynamic[][] = new int[denoms.length + 1][amount +1]; 
		
		//Without any coins we cannot make any value hence 0
		for(int c= 0 ; c < dynamic[0].length ; c++){
			dynamic[0][c] = 0;
		}
		
		// We will use this column for exact denomination
		// E.g. ways to make change for 25c using quarter -> 1 way
		for(int r= 0 ; r < dynamic.length ; r++){
			dynamic[r][0] = 1;
		}
		
		for(int r = 1 ; r < dynamic.length ; r++){
			for(int c = 1 ; c < dynamic[r].length ; c++){
				
				// How many ways we can make a value without using the new coin
				int withoutUsingNewDenom = dynamic[r-1][c]; 
				
				int usingNewDenom = 0; 
				if(c - denoms[r-1] >= 0){
					usingNewDenom = dynamic[r][c - denoms[r-1]];
				}
				 
				dynamic[r][c] = withoutUsingNewDenom + usingNewDenom;
			}
		}
		
		return dynamic[denoms.length][amount];
	}
	
	public static void main(String[] args) {
		int [] denoms = {1,5,10,25};
		int [] denoms_recur = {25,10,5,1};
		
		System.out.println(makeChange(100,denoms_recur,0));
		
		System.out.println(makeChangeDynamic(100,denoms));
	}
}
