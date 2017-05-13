package string_manip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Given two strings find how many anagrams of first string are present in the second string
 * @author mdmehta
 * 
 * Complexity 
 * 
 * S , B length of strings 
 * 
 * O(S) + O(B) * O(S_Unique)
 *
 */
public class FindAnagrams {

	private static ArrayList<Integer> findAnagram(String s, String b){
	
		ArrayList<Integer> anagramPosition = new ArrayList<Integer>();
		Map<Integer,Integer> map_sCharCount = new HashMap<Integer,Integer>();
		
		//Find out characters in small string 
		for(int i=0; i < s.length(); i ++){
			int c = s.charAt(i);
			if(map_sCharCount.containsKey(c)){
				int count = map_sCharCount.get(c);
				map_sCharCount.put(c,++count);
			}else{
				map_sCharCount.put(c,1);
			}
		}
		
		Map<Integer,Integer> map_currentCount = new HashMap<Integer,Integer>();
		
		/**
		 * In sliding window we will maintain count of characters we have seen in last s.length characters
		 */
		
		for(int i=0; i < b.length() ; i ++){
			int c = b.charAt(i);
			Integer count = map_currentCount.get(c);
			if(count == null){count = 0;}
			map_currentCount.put(c, ++count);
			
			int i_remove = i - s.length();
			if(i_remove >= 0){
				int charRemove = b.charAt(i_remove);
				int count_remove = map_currentCount.get(charRemove);
				map_currentCount.put(charRemove, --count_remove);
			}
			
			boolean isAnagram = true;
			// Lets compare count
			for(Integer c_compare : map_sCharCount.keySet()){
				Integer count_seen = map_currentCount.get(c_compare);
				Integer count_orig = map_sCharCount.get(c_compare);
				
				if(count_seen == null){count_seen = 0 ;}
				if(count_orig == null){count_orig = 0 ;}
				
				if(count_seen != count_orig){
					isAnagram = false;
					break;
				}
			}
			
			if(isAnagram){
				anagramPosition.add(i_remove + 1);
			}
		}
	
		return anagramPosition;
	}
	
	public static void main(String[] args) {
		String s = "abbc";
		String b = "dbabcabbacaabcbabcacbb";
		
		ArrayList<Integer> anagramPosition = findAnagram(s,b);
		
		for (Integer index : anagramPosition) {
			for(int i = 0 ; i < s.length() ; i ++){
				System.out.print(b.charAt(index + i) + " ");
			}
			System.out.println();
		}

		
	}
}
