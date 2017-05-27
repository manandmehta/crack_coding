package string_manip;

/**
 * Find out if a string is permutation of palindrome 
 * @author mdmehta
 */
public class PalindromePermutation_1_4 {

	private static boolean isPelindromePermutation(String s){
		if(s == null || s.trim().isEmpty()){
			return false;
		}

		// This Is how you convert string to char array
		char c_ary[] = s.toCharArray();
		int uniCodeMap[] = new int[128];

		for(int i= 0 ; i < uniCodeMap.length ; i++){
			uniCodeMap[i] = 0 ;
		}

		int oddNumbersSeen = 0 ; 
		for(char c: c_ary){
			int c_int = c - 'a';
			if(c_int < 0 || c_int > 'z' ){
				continue;
			}
			uniCodeMap[c_int]++;

			/**
			 * Instead of doing it in separate loop, we keep count how many odds we have seen so far
			 * With palindrome, most of them will eventually become even and reduce the oddNumbersSeen 
			 */
			if(uniCodeMap[c_int] % 2 == 0){
				oddNumbersSeen--;
			}else{
				oddNumbersSeen++;
			}
		}

		// A palindrome cannot have more than one character in odd number
		if(oddNumbersSeen > 1){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPelindromePermutation("taco cat"));
		System.out.println(isPelindromePermutation(" cat co ta"));
		System.out.println(isPelindromePermutation("aba"));
		System.out.println(isPelindromePermutation("a"));
		System.out.println(isPelindromePermutation("abc"));
	}
}
