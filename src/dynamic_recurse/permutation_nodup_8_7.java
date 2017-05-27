package dynamic_recurse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The approach finds permutation even if there are duplicates (Problem 8_8)
 * @author mdmehta
 *
 */
public class permutation_nodup_8_7 {

	private static List<String> findPermutation(Set<String> charSet){

		// Mistake: The initial basecase was for two characters. It would have failed for string with single character
		if(charSet.size() == 1){
			String myChar[] = new String[1];
			for(String c : charSet){
				myChar[0] = c;
			}
			List <String> permOfOne = new ArrayList<String>();
			permOfOne.add(myChar[0]);
			return permOfOne;
		}
		
		
		List <String> permutation = new ArrayList<String>();
		for(String c: charSet){
			Set<String> smallSet = new HashSet<String>(charSet);
			smallSet.remove(c);
			
			List<String> smallPermutation = findPermutation(smallSet);
			
			for(String c_s : smallPermutation){
				// Prefix with the character we are processing 
				permutation.add(c + c_s);
			}
		}
		
		return permutation;
	}
	
	public static void main(String[] args) {
		Set<String> strSet = new HashSet<String>();
		strSet.add("a");
		strSet.add("b");
		strSet.add("c");
		strSet.add("d");

		List<String> permutation =  findPermutation(strSet);
		
		System.out.println(permutation.size());
		System.out.println("---------------------------------------");
		System.out.println(permutation);
		
	}
}
