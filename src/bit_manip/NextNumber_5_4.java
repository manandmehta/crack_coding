package bit_manip;

/**
 * Find the next big & small number by keeping the number of bits same (1s and 0s)
 */
public class NextNumber_5_4 {

	/**
	 * We will flip 0->1 and 1->0 to achieve next big number
	 * If i is position of 0->1
	 *    j is position of 1->0
	 *   The number is big only when i > j
	 * @param n
	 * @return
	 */
	static int getNext(int n){
		
		// Consider p is the position where we perform 0 -> 1
		
		int c = n;
		int c0 = 0; // # of 0s before position p
		int c1 = 0; // # of 1s before position p
		
		/*
		  We are in the search of finding 0 that happens to appear after 1
		  That is the only 0 -> 1 we can do to make the number bigger
		 */
		
		// Find out all trailing 0s   111000
		while(  ((c & 1)== 0) && c != 0 ){
			c0++;
			c = c >> 1;
		}
		
		// Find out all the trailing 1s, it will stop when we hit 0, that is the position p 
		while((c & 1) == 1){
			c1++;
			c = c >> 1;
		}
		
		/* Why we did this ? 
		 	If there are no trailing 0s than the first loop which will his is for 1s
		 	it will stop as soon as we hit 0 (which is position p)
		 	
		 	If there are leading 0s, we cannot flip them to make number bigger as there is no 1 right to it
		 	hence we need to go past them to reach first 1 and then find 0 that we can flip
		 */
		
		
		if(c0 + c1 == 31 || c0 + c1 == 0){
			// If the number is 111....110000....0 we will have c0+c1 = 31
			// If the number is all 1111..111 we will have c0+c1 = 0
			return -1;
		}
		
		int p = c0 + c1;
		
		/* Flip 0 -> 1 at position p
		   We will create the mask of 00001000000 where 1 is at position p and OR it with number
		 */
		n = n | (1 << p);
		
		/*
		  Now we need to rearrange all 1s and 0s to its right. We need to place c1-1 1s followed by 0s
		  e.g.  ...p00011
		 */
		
		// First we clear all bits right of p. The mask will have 0s till p-1 position		
		int a = 1 << p; // 1 at pth position
		int b = a -1 ;  // all 1s till p-1 position
		int mask = ~b;         // All 1s from p onwards, all 0s till p-1
		n = n & mask;
		
		// Now we or it with c1-1 ones to the right come up with final answer
		
		n = n | (1 << (c1 - 1))- 1; // Insert c1-1 ones to the right
		
		return n;
	}
}
