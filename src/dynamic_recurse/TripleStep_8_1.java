package dynamic_recurse;

public class TripleStep_8_1 {
	private static int findNumWays(int n){
		int a[] = new int[n];
		int i = 0 ;

		while(i < n){
			int totalWays = 0 ; 
			if(i == 0 || i == 1 || i == 2){
				// We can directly reach here
				totalWays ++;
			}
			
			if(i-1 >= 0){
				totalWays = totalWays + a[i-1];
			}
			if(i-2 >= 0){
				totalWays = totalWays + a[i-2];
			}
			if(i-3 >= 0){
				totalWays = totalWays + a[i-3];
			}
			
			a[i] = totalWays;
			i++;
		}
		return a[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(findNumWays(4));
	}

}
